package com.chunjae.spring7.controller;

import com.chunjae.spring7.dto.EmpDTO;
import com.chunjae.spring7.dto.PageConstructor;
import com.chunjae.spring7.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmpController {
    private final EmpService empService;
    public EmpController(EmpService empService){
        this.empService=empService;
    }
    @GetMapping({"/list/{curr}","/list"})
    public String list(@PathVariable(required = false) String curr
            , @RequestParam(required = false) String search
            , @RequestParam(required = false) String searchTxt
            , Model model){
        Pattern pattern = Pattern.compile("(^|d*$)");
        if("employee_id".equals(search) || "department_id".equals(search)){
            Matcher m = pattern.matcher(searchTxt);
            if(!m.find())
                searchTxt="";
            model.addAttribute("searchTxt",searchTxt);
        }
        int currPage = (curr!=null) ? Integer.parseInt(curr) : 1;
        // startRow 는 count 와 상관 없기 때문에 count 메서드를 따로 만들지 않으려고 했으나,
        // 애초에 페이징 개념은 각 페이지마다 새로운 sql 이 적용되는 것이기 때문에 불가능했다.
        // 전체를 한번에 불러와서 각각의 페이지마다 10개씩 뿌려주는 방법은 다시 생각해 볼것.
        int totalCount = empService.countEmpList(search,searchTxt);
        PageConstructor page = new PageConstructor(currPage,totalCount);
        List<EmpDTO> list = empService.empList(search,searchTxt,page.getStartRow(),PageConstructor.getPageSize());
        model.addAttribute("list",list);
        model.addAttribute("page",page);
        model.addAttribute("search",search);
        model.addAttribute("searchTxt",searchTxt);
        return "emp/emplist";
    }

    @GetMapping("/detail/{eid}")
    public String detail(@PathVariable int eid, Model model){
        EmpDTO emp = empService.detailEmp(eid);
        model.addAttribute("emp",emp);
        if(emp==null)
            model.addAttribute("isNull",true);
        else
            model.addAttribute("isNull",false);
        return "emp/detail";
    }

    // 업데이트 안됨 으악
    @PostMapping("/update")
    public String update(EmpDTO dto){
        System.out.println(dto);
        //empService.updateEmp(dto);
        return "redirect:/list";
    }

    @GetMapping("/del/{eid}")
    public String del(@PathVariable int eid){
        empService.deleteEmp(eid);
        return "redirect:/list";
    }
}
