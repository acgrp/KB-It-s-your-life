package org.scoula.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;


@Configuration
@EnableWebSecurity  // Spring Security 활성화
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 문자셋 필터 메서드
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");           // UTF-8 인코딩 설정
        encodingFilter.setForceEncoding(true);         // 강제 인코딩 적용
        return encodingFilter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // CSRF 필터보다 앞에 인코딩 필터 추가
        http.addFilterBefore(encodingFilter(), CsrfFilter.class);

        // 기본 설정으로 시작 - 모든 요청에 인증 필요 (삭제예정)
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .logout();

        // 경로별 접근 권한 설정
        http.authorizeRequests()
                // 모든 사용자 허용
                .antMatchers("/security/all").permitAll()

                // ADMIN만 허용
                .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")

                // MEMBER, ADMIN 중 하나라도 만족하면 허용
                .antMatchers("/security/member").access("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')")

                // 로그인 사용자에게 허용 (예시)
                .antMatchers("/board/write", "/board/modify", "/board/delete").authenticated();



        // 폼 기반 로그인 활성화 (모든 설정이 기본값)
        http.formLogin()

                // 커스텀 로그인 페이지 설정 (Security 기본 로그인 사용 X, 사용자가 만든 로그인 페이지 사용!)
                .loginPage("/security/login")           // 로그인 폼 GET 요청 URL
                .loginProcessingUrl("/security/login")  // 로그인 처리 POST 요청 URL
                .defaultSuccessUrl("/");                // 로그인 성공 시 리다이렉트 URL

        // 폼 기반 로그인 활성화

        // 로그아웃 설정
        http.logout()
                .logoutUrl("/security/logout")                    // POST: 로그아웃 요청 URL
                .invalidateHttpSession(true)                      // 세션 무효화
                .deleteCookies("remember-me", "JSESSION-ID")      // 쿠키 삭제
                .logoutSuccessUrl("/security/logout");            // GET: 로그아웃 완료 후 이동할 페이지

    }

    // 테스트 사용자 정보 설정
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("configure .........................................");

        // 관리자 계정 설정
        auth.inMemoryAuthentication()
                .withUser("admin")          // 사용자 ID
                .password("{noop}1234")     // 비밀번호 ({noop}는 암호화 없음)
                .roles("ADMIN");            // ROLE_ADMIN 권한 부여

        // 일반 사용자 계정 설정
        auth.inMemoryAuthentication()
                .withUser("member")         // 사용자 ID
                .password("{noop}1234")     // 비밀번호
                .roles("MEMBER");           // ROLE_MEMBER 권한만 부여
    }
}