package com.chunjae.spring7.controller;

import com.chunjae.spring7.dto.EmpDTO;
import com.chunjae.spring7.dto.PageConstructor;
import com.chunjae.spring7.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
