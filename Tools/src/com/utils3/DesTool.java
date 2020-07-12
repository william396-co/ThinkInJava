package com.utils3;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DesTool {
    private static final String encoding = "utf-8";

    public DesTool() {
    }

    public static String encode(String plainText, String key) throws Exception {
        String iv = key.substring(0, 8);
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(1, deskey, ips);
        byte[] encryptData = cipher.doFinal(plainText.getBytes("utf-8"));
        return Base64.encode(encryptData);
    }

    public static String decode(String encryptText, String key) throws Exception {
        String iv = key.substring(0, 8);
        Key deskey = null;
        DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
        deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
        cipher.init(2, deskey, ips);
        byte[] decryptData = cipher.doFinal(Base64.decode(encryptText));
        return new String(decryptData, "utf-8");
    }

    public static String padding(String str) {
        try {
            byte[] oldByteArray = str.getBytes("UTF8");
            int numberToPad = 8 - oldByteArray.length % 8;
            byte[] newByteArray = new byte[oldByteArray.length + numberToPad];
            System.arraycopy(oldByteArray, 0, newByteArray, 0, oldByteArray.length);

            for(int i = oldByteArray.length; i < newByteArray.length; ++i) {
                newByteArray[i] = 0;
            }

            return new String(newByteArray, "UTF8");
        } catch (UnsupportedEncodingException var5) {
            System.out.println("Crypter.padding UnsupportedEncodingException");
            return null;
        }
    }

    public static class Base64 {
        private static final char[] legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

        public Base64() {
        }

        public static String encode(byte[] data) {
            int start = 0;
            int len = data.length;
            StringBuffer buf = new StringBuffer(data.length * 3 / 2);
            int end = len - 3;
            int i = start;
            int n = 0;

            int d;
            while(i <= end) {
                d = (data[i] & 255) << 16 | (data[i + 1] & 255) << 8 | data[i + 2] & 255;
                buf.append(legalChars[d >> 18 & 63]);
                buf.append(legalChars[d >> 12 & 63]);
                buf.append(legalChars[d >> 6 & 63]);
                buf.append(legalChars[d & 63]);
                i += 3;
                if (n++ >= 14) {
                    n = 0;
                    buf.append(" ");
                }
            }

            if (i == start + len - 2) {
                d = (data[i] & 255) << 16 | (data[i + 1] & 255) << 8;
                buf.append(legalChars[d >> 18 & 63]);
                buf.append(legalChars[d >> 12 & 63]);
                buf.append(legalChars[d >> 6 & 63]);
                buf.append("=");
            } else if (i == start + len - 1) {
                d = (data[i] & 255) << 16;
                buf.append(legalChars[d >> 18 & 63]);
                buf.append(legalChars[d >> 12 & 63]);
                buf.append("==");
            }

            return buf.toString();
        }

        private static int decode(char c) {
            if (c >= 'A' && c <= 'Z') {
                return c - 65;
            } else if (c >= 'a' && c <= 'z') {
                return c - 97 + 26;
            } else if (c >= '0' && c <= '9') {
                return c - 48 + 26 + 26;
            } else {
                switch(c) {
                    case '+':
                        return 62;
                    case '/':
                        return 63;
                    case '=':
                        return 0;
                    default:
                        throw new RuntimeException("unexpected code: " + c);
                }
            }
        }

        public static byte[] decode(String s) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            try {
                decode(s, bos);
            } catch (IOException var5) {
                throw new RuntimeException();
            }

            byte[] decodedBytes = bos.toByteArray();

            try {
                bos.close();
                bos = null;
            } catch (IOException var4) {
                System.err.println("Error while decoding BASE64: " + var4.toString());
            }

            return decodedBytes;
        }

        private static void decode(String s, OutputStream os) throws IOException {
            int i = 0;
            int len = s.length();

            while(true) {
                while(i < len && s.charAt(i) <= ' ') {
                    ++i;
                }

                if (i == len) {
                    break;
                }

                int tri = (decode(s.charAt(i)) << 18) + (decode(s.charAt(i + 1)) << 12) + (decode(s.charAt(i + 2)) << 6) + decode(s.charAt(i + 3));
                os.write(tri >> 16 & 255);
                if (s.charAt(i + 2) == '=') {
                    break;
                }

                os.write(tri >> 8 & 255);
                if (s.charAt(i + 3) == '=') {
                    break;
                }

                os.write(tri & 255);
                i += 4;
            }

        }
    }


    public static void main(String[] args) throws Exception {

        String params = "435455xsfdsgfsg";
        params = encode(params, "i3ring");
        System.out.println(params);
        params = Base64.encode(params.getBytes());
        System.out.println(params);
    }
}