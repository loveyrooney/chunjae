package com.chunjae.mvc_mybatis.controller;

import com.chunjae.mvc_mybatis.dto.EmpDTO;
import com.chunjae.mvc_mybatis.dto.PageConstructor;
import com.chunjae.mvc_mybatis.service.EmpSearchService;
import com.chunjae.mvc_mybatis.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequiredArgsConstructor
public class EmpController {
    private final EmpService service;
    private final EmpSearchService searchService;

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<EmpDTO> emplist = service.empList();
        model.addAttribute("emplist",emplist);
        return "emp/emplist";
    }

    @GetMapping("/emplist")
    public String searchlist(@RequestParam(required = false, defaultValue = "1") int currPage
            , @RequestParam(required = false, defaultValue = "") String search_ctg
            , @RequestParam(required = false, defaultValue = "") String search_txt, Model model){
        Pattern pattern = Pattern.compile("(^[0-9]*$)");
        if("employee_id".equals(search_ctg)){
            Matcher m = pattern.matcher(search_txt);
            if(m.find()){
                model.addAttribute("search_txt",search_txt);
            }else{
                search_txt="";
                model.addAttribute("search_txt",search_txt);
            }
        }
        int pageSize = 10;
        int blockSize = 5;
        int totalCount = searchService.totalCount(search_ctg,search_txt);
        PageConstructor page = new PageConstructor(currPage,totalCount,pageSize,blockSize);
        List<EmpDTO> searchlist = searchService.searchEmpList(search_ctg,search_txt,page.getStartRow(),pageSize);
        model.addAttribute("page",page);
        model.addAttribute("search",search_ctg);
        model.addAttribute("search_txt",search_txt);
        model.addAttribute("list",searchlist);
        return "emp/emplist";
    }

    @GetMapping("/emplist2")
    public String searchlist2(Model model){
        List<HashMap<String,Object>> listWithMap = searchService.searchEmpListReturnedMap();
        model.addAttribute("listWithMap",listWithMap);
        return "emp/searchlist";
    }
}