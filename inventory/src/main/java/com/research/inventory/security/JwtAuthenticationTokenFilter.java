package com.research.inventory.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.research.inventory.model.JwtAuthenticationToken;

/**

* The is the Token Filter .
* We are using OncePerRequest filter for the jwt token
* means for every request the token will be validated

* @version 1.0

* @author Prateek T

*/
public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    public JwtAuthenticationTokenFilter() {
        super("/rest/**");
    }

    /**
   	 * The method is used for handling the attempt of any api from the otken , 
   	 * It takes the request objects and validates the token and 
   	 * output the Authentication object for the token
   	 * 
   	 * @version 1.0
   	 * @author Prateek T
   	 */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

        String header = httpServletRequest.getHeader("Authorization");
        

        if (header == null || !header.startsWith("Bearer ")) {
            throw new RuntimeException("JWT Token is missing");
        }
        
        String authenticationToken = header.substring(6);
      
        JwtAuthenticationToken token = new JwtAuthenticationToken(authenticationToken);
        return getAuthenticationManager().authenticate(token);
    }


    /**
	 * The method is used for handling the successful attempt with valid token
	 * It takes request ,response,filter and Auth object and returns nothing 
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}
