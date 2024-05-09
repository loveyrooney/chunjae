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
    public String insert(){
      return "insertform";
   }

   @PostMapping("/insert_result")
    public String insertResult(EmpDTO dto){
       int eid = empService.insert(dto);
       return "redirect:detail/"+eid;
   }

   @GetMapping("/detail/{eid}")
    public String detail(@PathVariable int eid, Model model){
      EmpDTO dto = empService.detail(eid);
      if(dto!=null) {
          model.addAttribute("dto", dto);
          model.addAttribute("isNull",false);
      } else {
          model.addAttribute("isNull",true);
      }
      return "detail";
   }

   @PostMapping("/update_result")
    public String update(EmpDTO dto){
       empService.updateEmp(dto);
       return "redirect:/detail/"+dto.getEmployee_id();
   }

   @GetMapping("/del/{eid}")
    public String delEmp(@PathVariable int eid){
      empService.delEmp(eid);
      return "redirect:/list";
   }



}
