package com.utils3;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class MyDesTools {

    /**
     * DES加密
     *
     * @param data 加密数据
     * @param key  密钥
     * @return 返回加密后的数据
     */
    public static byte[] desEncrypt(byte[] data, String key, String charset) {
        try {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            byte[] k = charset == null || charset.trim().isEmpty() ? key.getBytes() : key.getBytes(charset);
            SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(k));
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(k));
            return cipher.doFinal(data);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * DES解密
     *
     * @param data 解密数据
     * @param key  密钥
     * @return 返回解密后的数据
     */
    public static String desDecrypt(byte[] data, String key, String charset) {
        try {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            byte[] k = charset == null || charset.trim().isEmpty() ? key.getBytes() : key.getBytes(charset);
            cipher.init(Cipher.DECRYPT_MODE, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(k)), new IvParameterSpec(k));
            if (charset == null || charset.trim().isEmpty()) {
                return new String(cipher.doFinal(data));
            }
            return new String(cipher.doFinal(data), charset);
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {

        String str = "ki1JvW2nfvvPWeGnsFmJT0sL1t4JIHgS";

        System.out.println(desDecrypt(str.getBytes(),"i3ring2343","UTF-8"));


    }
}
