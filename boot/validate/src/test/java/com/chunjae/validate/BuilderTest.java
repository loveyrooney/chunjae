package com.chunjae.validate;

import com.chunjae.validate.dto.MemberDTO;

public class BuilderTest {
    public static void main(String[] args) {

        // 기존의 생성자 방식으로 값 주입하려면 값의 순서를 지켜야 한다.
        MemberDTO dto1 = new MemberDTO("park@test.com","p123","박지성");
        // 빌더 패턴을 사용하는 경우 꼬리만 달면 되고, 값이 어떤 요소인지 바로 확인 할 수 있다.
        MemberDTO dto2 = MemberDTO.builder()
                                    .name("이강인")
                                    .id("lee@test.com")
                                    .pwd("l123")
                                    .build();

        System.out.println(dto1.getId());
        System.out.println(dto2.getId());
    }
}
