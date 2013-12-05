package com.supinfo.supcrowdfunder.util;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Author: Gaël Demette
 * Date: 23/11/13
 * Time: 17:15
 */
public class SecurityHelper {
    public static String generateSalt() {
        final Random rand = new SecureRandom();
        byte[] saltByte = new byte[16];
        rand.nextBytes(saltByte);
        String salt = Base64.encode(saltByte);
        return salt;
    }

    public static String hashPassword(String clearPassword, String salt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String password = clearPassword + salt;
        byte[] passwordBytes = password.getBytes();
        byte[] hashBytes = null;
        hashBytes = MessageDigest.getInstance("SHA-1").digest(passwordBytes);

        StringBuffer hashString = new StringBuffer();
        for (int i = 0; i < hashBytes.length; ++i) {
            String hex = Integer.toHexString(hashBytes[i]);
            if (hex.length() == 1) {
                hashString.append('0');
                hashString.append(hex.charAt(hex.length() - 1));
            } else {
                hashString.append(hex.substring(hex.length() - 2));
            }
        }
        return hashString.toString();
    }

}
