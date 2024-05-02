package com.chunjae.beans1;

import org.springframework.stereotype.Component;
/*
@Component : 보편적으로 사용
@Repository : data 액세스 계층의 DAO 또는 repository 클래스에 사용
@Service : 서비스 계층에 사용. 비즈니스 로직
@Controller : mvc 패턴에서 컨트롤러에 사용
 */
@Component(value="com1") // bean 의 id. 쓰지 않으면 클래스이름의 lowerCase 로 자동 지정.
public class Component1 {
    public void prt(){
        System.out.println("Component1 prt");
    }
}
