package com.cs308.config.key;

import java.security.SecureRandom;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class KeyFactory {

	public static String jwtKey;

	@PostConstruct
	public void init() throws Exception {
		generateKey();
	}

	public void generateKey() throws Exception {
/*
		SecureRandom random = new SecureRandom();
		jwtKey = new BigInteger(130, random).toString(32);
*/
		jwtKey = "secretkey";
		// TODO disable this before release
		System.out.println("JWT KEY: " + jwtKey + "\n\n\n");
	}

}