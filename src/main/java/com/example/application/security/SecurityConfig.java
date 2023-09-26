package com.example.application.security;

import com.example.application.views.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity // <1>
@Configuration
public class SecurityConfig extends VaadinWebSecurity { // <2>

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth ->
                auth.requestMatchers(
                    AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/images/*.png")).permitAll());  // <3>
        super.configure(http);
        setLoginView(http, LoginView.class); // <4>
    }

    @Bean
    public UserDetailsService users() {
        UserDetails ralph = User.builder()
                .username("ralph")
                .password("{noop}ralph")
                .roles("USER", "ADMIN")
                .build();
        UserDetails marielle = User.builder()
                .username("marielle")
                .password("{noop}marielle")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(ralph, marielle); // <5>
    }
}