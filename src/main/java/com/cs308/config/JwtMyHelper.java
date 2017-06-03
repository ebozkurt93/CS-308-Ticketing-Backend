package com.cs308.config;

import java.util.ArrayList;

import javax.servlet.ServletException;

import com.cs308.config.key.KeyFactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtMyHelper {

	public static String getJWTRoles(String jwt) throws ServletException {

		jwt = jwt.replace("Bearer ", "");
		Claims claims = Jwts.parser().setSigningKey(KeyFactory.jwtKey).parseClaimsJws(jwt).getBody();

		String roles = (String) claims.get("roles");
		return roles;
	}

	public static String getJwtEmail(String jwt) {
		jwt = jwt.replace("Bearer ", "");
		Claims claims = Jwts.parser().setSigningKey(KeyFactory.jwtKey).parseClaimsJws(jwt).getBody();
		String email = claims.getSubject();
		System.out.println(email);
		return email;
	}

	public static boolean getIfJWTUser(String jwt) throws ServletException {
		String roleList = getJWTRoles(jwt);
		if (roleList.equals("USER")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean getIfJWTAdmin(String jwt) throws ServletException {
		String roleList = getJWTRoles(jwt);
		if (roleList.equals("ADMIN")) {
			return true;
		} else {
			return false;
		}
	}

}