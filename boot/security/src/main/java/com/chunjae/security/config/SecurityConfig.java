package com.chunjae.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        // 아예 security 처리에서 배제할 항목
        return (web)->web.ignoring()
                .requestMatchers("/resources/**")
                .requestMatchers("/css/**")
                .requestMatchers("/js/**")
                .requestMatchers("/images/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        // csrf 사용 안함 -> http.csrf(csrf->csrf.disable()); 이렇게 쓰지 말 것.
        http.csrf(csrf-> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()));
        // authorization 설정
        http.authorizeHttpRequests(authorize->
                authorize.requestMatchers("/join", "/login","/logout").permitAll() // permitAll 은 security 처리하되, 모두에게 권한 부여
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/userlist").hasRole("USERS")
                        .requestMatchers("/main/**", "/list").hasAnyRole("ADMIN","USERS")
                        .anyRequest().authenticated()
        );
        // login / logout 설정
        http.formLogin(formLogin->formLogin.loginPage("/login")
                .loginProcessingUrl("/login") // form action 경로
                .defaultSuccessUrl("/main") // 로그인 성공 시 redirect 경로
                .permitAll());
        http.logout(logout->logout.logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID"));
        // exception page 설정
        http.exceptionHandling(exceptionConfig->exceptionConfig
                .accessDeniedHandler(new CustomAccessDeniedHandler("/error/403")));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
