package com.chunjae.logs.controller;

import com.chunjae.logs.exception.NoFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
slf4j : 로깅 추상화 라이브러리
        logbck : 로깅 프레임워크

        Fatal : 매우 심각한 에러, 프로그램 종료
        Error : 의도하지 않은 에러
        Warn : 에러가 될 수 있는 잠재적 가능성이 있는 경우
        Info : 명확한 의도가 있는 에러, 요구사항에 따라 시스템 동작을 보여줄때 사용
        Debug : Info 레벨보다 더 자세한 정보가 필요할 때, develope 환경에서 사용
        Trace : debug 보다 더 자세한 정보가 필요한 경우. 최종 프로덕션이나 커밋에 포함하면 안 됨
 */
@Controller
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger("HelloController.class");
    @GetMapping("/hello")
    public String sayHello(){
        String name="hong gil dong";
        logger.info("hello Controller {}",name);
        logger.debug("hello Controller {}",name);
        logger.warn("hello Controller {}",name);
        logger.error("hello Controller {}",name);
        return "hello";
    }

    @PostMapping("/result")
    public String result(@RequestParam int su1, @RequestParam int su2, Model model){
        model.addAttribute("result",su1/su2);
        return "result";
    }
    // 예외 발생한 경우 리턴할 페이지는 @ExceptionHandler 로 지정할 수 있다. 아래 처럼 컨트롤러 단에서 바로 사용할 수도 있고,
    // @ControllerDevice 가 적용된 ExceptionHandler 클래스를 따로 만들어서 거기서 관련된 예외들을 모아 관리할 수도 있다.
    @ExceptionHandler(ArithmeticException.class)
    public String handlerException(){
        return "error/exception2";
    }

    @GetMapping("/file/{f}")
    public String f1(@PathVariable String f) throws NoFileException {
        logger.info("file..{}",f);
        // 조건에 해당할 시 NoFileException 을 던짐(500 에러 발생), userException1 을 호출한다.
        if("aaa".equals(f))
            throw new NoFileException();
        return "test";
    }

    // eeee 라는 jsp 파일은 없기 때문에 404 에러 발생, userException2 를 호출한다.
    @GetMapping("/say")
    public String say(){
        return "eeee";
    }
}
