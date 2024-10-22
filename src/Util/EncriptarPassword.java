package Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncriptarPassword {
	public static String encriptarPassword(String contrasena) {

		 try {

	            MessageDigest digest = MessageDigest.getInstance("SHA-256");

	            byte[] hash = digest.digest(contrasena.getBytes());

	            StringBuilder hexString = new StringBuilder();


	            for (byte b : hash) {

	                String hex = String.format("%02x", b);

	                hexString.append(hex);

	            }


	            return hexString.toString();

	        } catch (NoSuchAlgorithmException e) {

	            throw new RuntimeException(e);

	        }

		

	}
}
