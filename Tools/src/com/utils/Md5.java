package com.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
    public Md5() {
    }

    static String byteHEX(byte ib) {
        char[] Digit = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] ob = new char[]{Digit[ib >>> 4 & 15], Digit[ib & 15]};
        String s = new String(ob);
        return s;
    }

    public static String getMD5(String original) {
        byte[] originalByte = original.getBytes();
        byte[] toDigest = null;
        String digestHexStr = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(originalByte);
            toDigest = md.digest();

            for(int i = 0; i < 16; ++i) {
                digestHexStr = digestHexStr + byteHEX(toDigest[i]);
            }

            return digestHexStr;
        } catch (NoSuchAlgorithmException var6) {
            var6.toString();
            return digestHexStr;
        }
    }

    public static String getMD5(String original, String charset) {
        byte[] originalByte = original.getBytes(Charset.forName(charset));
        byte[] toDigest = null;
        String digestHexStr = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(originalByte);
            toDigest = md.digest();

            for(int i = 0; i < 16; ++i) {
                digestHexStr = digestHexStr + byteHEX(toDigest[i]);
            }

            return digestHexStr;
        } catch (NoSuchAlgorithmException var7) {
            var7.toString();
            return digestHexStr;
        }
    }
}