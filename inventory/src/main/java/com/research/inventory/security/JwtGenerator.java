package com.research.inventory.security;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.research.inventory.model.User;
import com.research.inventory.serviceImpl.UserServiceImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * The is the JWT token generator . Here We generates the jwtUser object from
 * the given credentials and return this token to the user
 * 
 * @version 1.0
 * 
 * @author Prateek T
 * 
 */
@Component
public class JwtGenerator {

	@Autowired
	UserServiceImpl userService;

	/**
	 * The method is used for constructing a jwt token from the user credentials
	 * It takes user object and output the jwt token for it 
	 * 
	 * @version 1.0
	 * @author Prateek T
	 */
	public HashMap<String, String> generate(User jwtUser) {
		HashMap<String, String> userMap = new HashMap<>();
		System.out.println(jwtUser.getUsername());
		System.out.println(jwtUser.getPassword());
		UserDetails user = userService.loadUserByUsernamePassword(jwtUser.getUsername(), jwtUser.getPassword());
		if (user == null) {
			userMap.put("token", "invalid credentials");
			return userMap;
		}
		Claims claims = Jwts.claims().setSubject(user.getUsername());
		claims.put("username", String.valueOf(user.getUsername()));
		claims.put("role", user.getAuthorities().toArray()[0].toString());
		userMap.put("role", user.getAuthorities().toArray()[0].toString());

		userMap.put("token", Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "youtube").compact());
		return userMap;
	}
}
