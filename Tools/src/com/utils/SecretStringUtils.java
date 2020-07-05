package com.utils;

import com.sun.crypto.provider.SunJCE;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.Security;

public class SecretStringUtils {
    private static Log log = LogFactory.getLog(SecretStringUtils.class);
    private static final String key = "bowinkey";

    public SecretStringUtils() {
    }

    public static void main(String[] args) throws Exception {
        String content = "abc99982";
        System.out.println("加密前：" + content);
        System.out.println("加密密钥和解密密钥：bowinkey");
        String encrypt = encrypt(content);
        System.out.println("加密后：" + encrypt);
        String decrypt = decrypt(encrypt);
        System.out.println("解密后：" + decrypt);
    }

    public static String getAesEncrypt(String content) {
        return content;
    }

    public static String getAesDecrypt(String content) {
        return content;
    }

    public static String encrypt(String content) {
        String encrypt = null;
        if (content != null && !content.equals("")) {
            try {
                DeEnCode des = new DeEnCode("bowinkey");
                return des.encrypt(content);
            } catch (Exception var3) {
                var3.printStackTrace();
                log.error("Eorr found encrypting, msg: " + var3.getMessage());
                return (String)encrypt;
            }
        } else {
            return content;
        }
    }

    public static String decrypt(String content) {
        String encrypt = null;
        if (content != null && !content.equals("")) {
            try {
                DeEnCode des = new DeEnCode("bowinkey");
                return des.decrypt(content);
            } catch (Exception var3) {
                var3.printStackTrace();
                log.error("Eorr found decrypting, msg: " + var3.getMessage());
                return (String)encrypt;
            }
        } else {
            return content;
        }
    }

    private static String binary(byte[] bytes, int radix) {
        return (new BigInteger(1, bytes)).toString(radix);
    }

    private static String base64Encode(byte[] bytes) {
        return (new BASE64Encoder()).encode(bytes);
    }

    private static byte[] base64Decode(String base64Code) throws Exception {
        return !org.springframework.util.StringUtils.hasLength(base64Code) ? null : (new BASE64Decoder()).decodeBuffer(base64Code);
    }

    private static byte[] md5(byte[] bytes) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(bytes);
        return md.digest();
    }

    private static byte[] md5(String msg) throws Exception {
        return !org.springframework.util.StringUtils.hasLength(msg) ? null : md5(msg.getBytes());
    }

    private static String md5Encrypt(String msg) throws Exception {
        return !org.springframework.util.StringUtils.hasLength(msg) ? null : base64Encode(md5(msg));
    }

    private static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(encryptKey.getBytes()));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
        return cipher.doFinal(content.getBytes("utf-8"));
    }

    private static String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    private static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(decryptKey.getBytes()));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(2, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes);
    }

    private static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return !StringUtils.hasLength(encryptStr) ? null : aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
    }

    public static class DeEnCode {
        private String strDefaultKey;
        private Cipher encryptCipher;
        private Cipher decryptCipher;

        public String byteArr2HexStr(byte[] arrB) throws Exception {
            int iLen = arrB.length;
            StringBuffer sb = new StringBuffer(iLen * 2);

            for(int i = 0; i < iLen; ++i) {
                int intTmp;
                for(intTmp = arrB[i]; intTmp < 0; intTmp += 256) {
                    ;
                }

                if (intTmp < 16) {
                    sb.append("0");
                }

                sb.append(Integer.toString(intTmp, 16));
            }

            return sb.toString();
        }

        public byte[] hexStr2ByteArr(String strIn) throws Exception {
            byte[] arrB = strIn.getBytes();
            int iLen = arrB.length;
            byte[] arrOut = new byte[iLen / 2];

            for(int i = 0; i < iLen; i += 2) {
                String strTmp = new String(arrB, i, 2);
                arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
            }

            return arrOut;
        }

        public DeEnCode() throws Exception {
            this("bowinkey");
        }

        public DeEnCode(String strKey) throws Exception {
            this.strDefaultKey = "bowinkey";
            this.encryptCipher = null;
            this.decryptCipher = null;
            Security.addProvider(new SunJCE());
            Key key = this.getKey(strKey.getBytes());
            this.encryptCipher = Cipher.getInstance("DES");
            this.encryptCipher.init(1, key);
            this.decryptCipher = Cipher.getInstance("DES");
            this.decryptCipher.init(2, key);
        }

        public byte[] encrypt(byte[] arrB) throws Exception {
            return this.encryptCipher.doFinal(arrB);
        }

        public String encrypt(String strIn) throws Exception {
            return this.byteArr2HexStr(this.encrypt(strIn.getBytes()));
        }

        public byte[] decrypt(byte[] arrB) throws Exception {
            return this.decryptCipher.doFinal(arrB);
        }

        public String decrypt(String strIn) throws Exception {
            return new String(this.decrypt(this.hexStr2ByteArr(strIn)));
        }

        private Key getKey(byte[] arrBTmp) throws Exception {
            byte[] arrB = new byte[8];

            for(int i = 0; i < arrBTmp.length && i < arrB.length; ++i) {
                arrB[i] = arrBTmp[i];
            }

            Key key = new SecretKeySpec(arrB, "DES");
            return key;
        }
    }
}

