package com.research.inventory.security;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.stereotype.Component;

import com.research.inventory.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**

* The is the JWT token validator .
* Here We generates the jwtUser object from the received token and validate it
* and also We are fetching the role authorization from this user object

* @version 1.0

* @author Prateek T

*/
@Component
public class JwtValidator {


    private String secret = "youtube";

    /** 
	* The method is used for validating the jwt token
	* Takes a string token and output the user object corresponding to it
	* @version 1.0
	* @author Prateek T
	*/
    public JwtUser validate(String token) {

        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody(); 
            jwtUser = new JwtUser();
            jwtUser.setUserName(body.getSubject());
            jwtUser.setUserName((String) body.get("username"));
            jwtUser.setRole((String) body.get("role"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}
