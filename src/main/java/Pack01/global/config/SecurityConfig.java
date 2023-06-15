//package Pack01.global.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/").permitAll() // 퍼블릭 엔드포인트 설정
//                .anyRequest().authenticated() // 나머지 요청은 인증 필요
//                .and()
//                .formLogin() // 기본 로그인 폼 사용
//                .and()
//                .logout() // 로그아웃 설정
//                .and()
//                .csrf().disable(); // CSRF 비활성화 (개발 환경에서만 사용)
//    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            if ("user".equals(username)) {
//                return User.builder()
//                        .username("user")
//                        .password(passwordEncoder().encode("password"))
//                        .roles("USER")
//                        .build();
//            }
//            throw new UsernameNotFoundException("User not found.");
//        };
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new  BCryptPasswordEncoder();
//    }
//}
//
