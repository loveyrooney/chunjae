package com.chunjae.springmvc.controller;

import com.chunjae.springmvc.dto.ExamDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    // http://loalhost8080/hello
    @RequestMapping("/hello")
    public String sayHello(){
        // /WEB-INF/views/hello.jsp
        return "hello";
    }
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public void say(Model model){
        // request.setAttribute 와 같다.
        model.addAttribute("name","hong");
        model.addAttribute("age",20);
        // return 없으면 urlPattern 과 같은 이름의 jsp 를 찾는다.
    }


    // forward 방식
    @GetMapping("/form")
    public String form(){
        return "form";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(@RequestParam String name,
                         @RequestParam int age, @RequestParam String addr, Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("addr",addr);
        return "formresult";
    }

    @PostMapping("/result4")
    public String result4(@RequestParam String name, @RequestParam(defaultValue = "0") int age, @RequestParam(required = false, defaultValue = "서울") String addr, Model model){
        // 적지 않고 보냈을 경우 String 변수는 null 아니고 "" 로 처리되고, int 변수는 404 에러
        // jsp 에서는 없는 값을 null로 받을 수 있었지만 여기서는 required = true 가 기본설정이기 때문에 불가.
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("addr", addr);
        return "formresult";
    }

        // form input name 속성과 다른 변수명을 쓰려면 @RequestParam 에 속성지정
    @PostMapping("/result2")
    public String result2(@RequestParam(name="name") String form_name, @RequestParam("age") int form_age, @RequestParam String addr, Model model){
        model.addAttribute("name",form_name);
        model.addAttribute("age", form_age);
        model.addAttribute("addr", addr);
        return "formresult";
    }
        // jsp 방식
    @PostMapping("/result3")
    public String result3(HttpServletRequest request, Model model){
        model.addAttribute("name",request.getParameter("name"));
        model.addAttribute("age",request.getParameter("age"));
        model.addAttribute("addr",request.getParameter("addr"));
        //request.setAttribute("name",request.getParameter("name"));
        // setAttribute 를 해서 보내도 requestScope 안써도 받아진다.
        return "formresult";
    }

    @GetMapping("/formexam")
    public String formexam(){
        return "formexam";
    }

    @PostMapping("resultexam")
    public String resultexam(@RequestParam String id,@RequestParam String pwd,
                             @RequestParam String name, @RequestParam String addr,
                             @RequestParam String gender, @RequestParam String[] food,
                             @RequestParam String comment, Model model){
        model.addAttribute("id",id);
        model.addAttribute("pwd",pwd);
        model.addAttribute("name",name);
        model.addAttribute("addr",addr);
        model.addAttribute("gender",gender);
        model.addAttribute("food",food);
        model.addAttribute("comment",comment);
        return "resultexam";
    }
        // dto로 받으면 전달 필요없다. input name 과 dto 필드명이 같아야 한다.
    @PostMapping("resultexam2")
    public String resultexam2(ExamDTO dto){
        return "resultexam2";
    }

        // model 에 넣어서 보낼 수도 있다. (dto 이름 바꾸고 싶으면)
    @PostMapping("resultexam3")
    public String resultexam3(@ModelAttribute("mdto") ExamDTO dto){
        return "resultexam3";
    }


    // sendRedirect 방식
    @GetMapping("/redirect")
    public String reform(){
        return "redirect:form"; // /form 으로 다시 간다.
    }


    // ModelAndView
    @GetMapping("/mav")
    public ModelAndView mav(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","손흥민");
        mav.addObject("addr","런던");
        mav.addObject("age",32);
        mav.addObject("comment","안녕하세요");
        mav.setViewName("mav"); // 이거 안 쓰면 urlPattern 과 같은 이름의 jsp 로드
        return mav;
    }


}
