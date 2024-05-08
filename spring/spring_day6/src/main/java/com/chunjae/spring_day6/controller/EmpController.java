package com.chunjae.spring_day6.controller;
import com.chunjae.spring_day6.dto.EmpDTO;
import com.chunjae.spring_day6.serivce.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpController {
   private EmpService empService;
  public EmpController(EmpService empService)
  {
      this.empService=empService;
  }

   @GetMapping("/list")
   public String emplist(Model model){
       List<EmpDTO> list= empService.list();
       model.addAttribute("list", list);
      return "emplist";
   }

   @GetMapping("/insert")
    public String insert(Model model){
      model.addAttribute("isUpdate",false);
      return "insertform";
   }

   @PostMapping("/insert_result")
    public String insertResult(EmpDTO dto){
       int eid = empService.insert(dto);
       return "redirect:detail/"+eid;
   }

   @GetMapping("/detail/{eid}")
    public String detail(@PathVariable String eid, Model model){
      EmpDTO dto = empService.detail(eid);
      if(dto!=null) {
          model.addAttribute("dto", dto);
          model.addAttribute("isNull",false);
      } else {
          model.addAttribute("isNull",true);
      }
      return "detail";
   }

    // update 리턴 isNull 설정해서 보내기
    // css, js 404 해결하기

}
