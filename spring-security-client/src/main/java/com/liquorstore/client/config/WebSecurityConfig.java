package com.liquorstore.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig {

//    @Autowired
//    private CustomAuthenticationProvider customAuthenticationProvider;

    private static final String[] WHITE_LIST_URLS = {
//            "/hello",
            "/register",
            "/verifyRegistration",
            "/resendVerificationToken",
            "/resetPassword",
            "/changePassword",
            "/savePassword",
            "/validateOTP",
            "/addContactNumber"
    };

//    @Autowired
//    public void bindAuthenticationProvider(AuthenticationManagerBuilder authenticationManagerBuilder) {
//        authenticationManagerBuilder
//                .authenticationProvider(customAuthenticationProvider);
//    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .antMatchers(WHITE_LIST_URLS).permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

}
