package com.chunjae.spring8.controller;

import com.chunjae.spring8.dto.TempDTO;
import com.chunjae.spring8.dto.UserDeptDTO;
import com.chunjae.spring8.service.UserDeptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserDeptController {
    private UserDeptService service;
    public UserDeptController(UserDeptService service){
        this.service=service;
    }
    @GetMapping("/list")
    public String list(Model model){
        List<UserDeptDTO> list = service.findUserDeptList();
        model.addAttribute("list",list);
        return "deptlist";
    }

    @GetMapping("/list2")
    public @ResponseBody List<UserDeptDTO> list2(){
        return service.findUserDeptList();
    }

    @GetMapping("/detaildept/{did}")
    public String detail(@PathVariable int did, Model model){
        UserDeptDTO dto = service.findUserDept(did);
        model.addAttribute("dto",dto);
        return "detaildept";
    }


}
