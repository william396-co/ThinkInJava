package com.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAUtils {
    public static final String SIGN_ALGORITHMS = "SHA-1";

    public SHAUtils() {
    }

    public static String sign(String content, String inputCharset) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(content.getBytes(inputCharset));
            byte[] messageDigest = digest.digest();
            StringBuffer hexString = new StringBuffer();

            for(int i = 0; i < messageDigest.length; ++i) {
                String shaHex = Integer.toHexString(messageDigest[i] & 255);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }

                hexString.append(shaHex);
            }

            return hexString.toString().toUpperCase();
        } catch (NoSuchAlgorithmException var7) {
            var7.printStackTrace();
        } catch (UnsupportedEncodingException var8) {
            var8.printStackTrace();
        }

        return null;
    }
}
