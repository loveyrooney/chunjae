package com.chunjae.validate.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@Builder   //전체에 적용할 때는 AllArgsConstructor 와 함께 써야 한다.
@AllArgsConstructor
public class MemberDTO {
    @NotEmpty(message = "id를 입력하세요.")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]+$", message = "첫 글자는 영문 대소문자, 전체는 영문 대소문자, 숫자만 가능")
    private String id;

    @NotEmpty(message = "패스워드를 입력하세요.")
    @Size(min = 4, max = 20, message = "비밀번호는 4~20자 이내에 있어야 합니다.")
    private String pwd;

    @NotEmpty(message = "이름을 입력하세요.")
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9가-힣]+$", message = "닉네임은 영문 대소문자, 숫자, 한글 사용가능")
    private String nickname;

    @NotNull(message = "나이를 입력하세요.")
    @Min(value = 1, message = "1살 이상부터 입력 가능합니다.")
    private Integer age;

//    @Builder  생성자에 적용도 가능
    public MemberDTO(String id, String pwd, String name){
        this.id=id;
        this.pwd=pwd;
        this.name=name;
    }
}
