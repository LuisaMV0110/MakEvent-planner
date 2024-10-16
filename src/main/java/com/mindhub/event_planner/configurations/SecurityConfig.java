package com.mindhub.event_planner.configurations;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( path -> {
                    path.requestMatchers("/index.html", "/assets/js/index.js", "/assets/css/style.css", "/assets/img/**" ,"/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html", "/h2-console/**", "/api/event/public/all","/api/event/public/{id}", "/api/location/all", "/api/location/{id}", "/api/comment/public/all", "/api/comment/public/{id}", "/api/like/public/all", "/api/like/public/{id}").permitAll()
                            .requestMatchers("/api/customer/all", "/api/customer/{id}", "/api/admin/all", "/api/admin/{id}", "/api/manager/all", "/api/manager/{id}").hasAuthority("ADMIN")
                            .requestMatchers("/api/user/all", "/api/user/{id}", "/api/customerEvent/all", "/api/event/auth/all", "/api/event/auth/{id}").hasAnyAuthority("MANAGER", "ADMIN")
                            .requestMatchers("/events.html", "/event.html","/api/eventLocation/all", "/api/eventLocation/{id}",  "/api/comment/auth/all", "/api/comment/auth/{id}", "/api/like/auth/all", "/api/like/auth/{id}").hasAnyAuthority("USER","MANAGER", "ADMIN")
                            .requestMatchers(HttpMethod.POST, "/api/register", "/api/login").permitAll()
                            .requestMatchers(HttpMethod.POST, "/api/admin/register", "/api/manager/register").hasAuthority("ADMIN")
                            .requestMatchers(HttpMethod.POST,"/api/event/auth/create", "/api/eventLocation/auth/create").hasAuthority("MANAGER")
                            .requestMatchers(HttpMethod.POST,"/api/customerEvent/auth/create").hasAuthority("USER")
                            .requestMatchers(HttpMethod.POST,"/api/location/auth/create").hasAnyAuthority("MANAGER", "ADMIN")
                            .requestMatchers(HttpMethod.POST,"/api/logout").hasAnyAuthority("USER","MANAGER", "ADMIN")
                            .anyRequest().authenticated();
                } )
                .csrf(AbstractHttpConfigurer::disable)
                .headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.frameOptions(
                        HeadersConfigurer.FrameOptionsConfig::disable))
                .formLogin( formLogin -> {
                    formLogin.loginPage("/index.html")
                            .loginProcessingUrl("/api/login")
                            .usernameParameter("email")
                            .passwordParameter("password")
                            .successHandler((request, response, authentication) -> clearAuthenticationAttributes(request))
                            .failureHandler((request, response, exception) -> response.sendError(401))
                            .permitAll();
                })
                .logout(httpSecurityLogoutConfigurer ->
                        httpSecurityLogoutConfigurer
                                .logoutUrl("/api/logout")
                                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                                .deleteCookies("JSESSIONID"))
                .rememberMe(Customizer.withDefaults());

        http.exceptionHandling(httpSecurityExceptionHandlingConfigurer -> httpSecurityExceptionHandlingConfigurer.authenticationEntryPoint((request, response, authException) -> response.sendError(401)));

        return http.build();
    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }
    }

}