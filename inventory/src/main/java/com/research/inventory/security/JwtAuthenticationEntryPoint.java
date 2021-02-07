package com.research.inventory.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**

* The is the the Authentication Entry point  ,the commence method will be called when
* the requesting user is not authorized.

* @version 1.0

* @author Prateek T

*/

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	/** 
	* The method is used for handling the unauthorized request from invalid token
	* Takes a request token and output Unauthorized as response
	* @version 1.0
	* @author Prateek T
	*/
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UNAUTHORIZED");
    }
}
