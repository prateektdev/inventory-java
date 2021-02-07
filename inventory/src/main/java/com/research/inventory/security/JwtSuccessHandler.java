package com.research.inventory.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**

* The is the Successful authentication handler class ,
* Means When the jwt token will be validated ,It will redirect here.

* @version 1.0

* @author Prateek T

*/

public class JwtSuccessHandler implements AuthenticationSuccessHandler{
	
	/** 
	* The method is used for handling the successful request from jwt token
	* Takes a request token and output authorized as response
	* @version 1.0
	* @author Prateek T
	*/
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("Successfully Authentication");
    }
}
