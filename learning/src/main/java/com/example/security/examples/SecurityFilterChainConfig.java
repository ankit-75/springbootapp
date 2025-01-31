//package com.example.security.examples;
//
////https://www.youtube.com/watch?v=h-9vhFeM3MY&t=105s
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
//@Configuration
//public class SecurityFilterChainConfig {
//
//    private AuthenticationProvider authenticationProvider;
//    private JWTAuthenticationFilter jwtAuthenticationFilter;
//
//    public SecurityFilterChainConfig(AuthenticationProvider authenticationProvider, JWTAuthenticationFilter jwtAuthenticationFilter) {
//        this.authenticationProvider = authenticationProvider;
//        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//    }
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                //.csrf().disable()
//                .authorizeHttpRequests(customizer -> customizer
//                        .requestMatchers("/api/v1/customer")
//                        .permitAll()
//                        .anyRequest()
//                        .authenticated())
//                //.requestMatchers(HttpMethod.POST.toString(), "/api/v1/customer")
//                //.permitAll()
//               // .anyRequest()
//               // .authenticated()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthenticationFilter,
//                        UsernamePasswordAuthenticationFilter.class);
//
//                //.au
//        return httpSecurity.build();
//    }
//}
