package com.hash;

import java.security.MessageDigest;
import java.util.Base64;

public class PasswordHash {
	public static String getHashPassword(String password){
		try {
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(password.getBytes());
	        return Base64.getEncoder().encodeToString(md.digest());
	    }
	    catch(java.security.NoSuchAlgorithmException exception) {
	    	exception.printStackTrace();
	    }
		return null;
	}
	
public static void main(String[] args) {
	System.out.println("HashPassword is: " + PasswordHash.getHashPassword("kieserver1!"));
}
}
