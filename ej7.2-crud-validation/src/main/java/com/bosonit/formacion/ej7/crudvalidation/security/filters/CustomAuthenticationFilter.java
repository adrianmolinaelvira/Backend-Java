package com.bosonit.formacion.ej7.crudvalidation.security.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

//Used for login
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    //Executed when login attempt
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password); //We generate the JWT token

        return authenticationManager.authenticate(authenticationToken); //We add the token as a valid one to the manager
    }

    //Executed if authentication is successful to give the user his JWT token
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal(); //returns the user that has successfully authenticated

        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes()); //Create hash algorithm

        String access_token = JWT.create()
                .withSubject(user.getUsername()) //data to create the token from
                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000)) //expiration time
                .withIssuer(request.getRequestURL().toString()) //Who signs the token
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList()) //link the roles to the token
                .sign(algorithm); //We create the token with the algorithm

        String refresh_token = JWT.create()
                .withSubject(user.getUsername()) //data to create the token from
                .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000)) //expiration time
                .withIssuer(request.getRequestURL().toString()) //Who signs the token
                .sign(algorithm); //We create the token with the algorithm

        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", access_token);
        tokens.put("refresh_token", refresh_token);

        response.setContentType(APPLICATION_JSON_VALUE); //we set the response type as a JSON
        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    }
}
