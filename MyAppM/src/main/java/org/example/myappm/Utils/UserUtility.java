package org.example.myappm.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserUtility {

    public static boolean verifyPassword(String password, String storedPassword){
        String passwordHash = hashPassword(password);
        return  passwordHash.equals(storedPassword);
    }


    public static boolean doPasswordsMatch(String password1, String password2){
        return password1 !=null && password1.equals(password2);
    }


    public static String hashPassword(String password){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return bytesToHex(hash);
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("Password hashing error: " + e);
        }
    }


    private static String bytesToHex(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for(byte b: bytes){
            sb.append(String.format("%02x", b));
        }

        return  sb.toString();
    }
}
