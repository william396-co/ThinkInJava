package com.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSha256 {
    public HmacSha256() {
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();

        for(int n = 0; b != null && n < b.length; ++n) {
            String stmp = Integer.toHexString(b[n] & 255);
            if (stmp.length() == 1) {
                hs.append('0');
            }

            hs.append(stmp);
        }

        return hs.toString().toLowerCase();
    }

    public static String sign(String content, String secret) {
        String hash = "";

        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(content.getBytes());
            hash = byteArrayToHexString(bytes);
        } catch (Exception var6) {
            System.out.println("Error HmacSHA256 ===========" + var6.getMessage());
        }

        return hash;
    }
}
