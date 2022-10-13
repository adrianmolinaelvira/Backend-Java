package com.bosonit.formacion.ej7.crudvalidation.security;

import com.bosonit.formacion.ej7.crudvalidation.security.filters.CustomAuthenticationFilter;
import com.bosonit.formacion.ej7.crudvalidation.security.filters.CustomAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //Custom login
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean(authenticationConfiguration));
        customAuthenticationFilter.setFilterProcessesUrl("/api/login"); //Creates a custom login endpint using our custom filter
        http.authorizeRequests().antMatchers(POST, "/api/login").permitAll();
        http.addFilter(customAuthenticationFilter); //Adds our custom Authentication Filter

        //Adds Authorization Filter
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class); //Adds the filter before any other filter

        //Endpoints filter
        http.csrf().disable(); //Because it is a REST API, and we don't save user date between sessions (Stateless app)
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers(POST, "/addperson").hasAnyAuthority("admin");
        http.authorizeRequests().anyRequest().authenticated(); //Allows only authenticated user
        //http.authorizeRequests().anyRequest().permitAll(); //Allows everyone to access all the resources
        //http.authorizeRequests().antMatchers(GET, "/test").permitAll(); //Allows everyone to access this resource

        //http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean(authenticationConfiguration))); //Allows access to everyone to the default Spring Security login ("/login")

        return http.build();
    }

    //Creates the Authenticator Manager
    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
