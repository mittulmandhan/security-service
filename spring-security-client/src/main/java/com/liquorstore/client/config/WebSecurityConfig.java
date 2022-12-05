package com.liquorstore.client.config;

import com.liquorstore.client.filter.JwtFilter;
import com.liquorstore.client.serviceimpl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class WebSecurityConfig {

//    @Autowired
//    private CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    private static final String[] WHITE_LIST_URLS = {
//            "/hello",
            "/register",
            "/verifyRegistration",
            "/resendVerificationToken",
            "/resetPassword",
            "/changePassword",
            "/savePassword",
            "/validateOTP",
            "/addContactNumber",
            "/authenticate"
    };

//    @Bean
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
//                .formLogin(Customizer.withDefaults())
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(
                jwtFilter,
                UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

}
