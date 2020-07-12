package com.Utils2;

import java.io.PrintStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import sun.misc.BASE64Encoder;

public class Encryptor
{
  public static String decrypt(String message, String key)
    throws Exception
  {
    byte[] bytesrc = convertHexString(message);
    Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
    SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
    IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
    cipher.init(2, secretKey, iv);
    byte[] retByte = cipher.doFinal(bytesrc);
    return new String(retByte);
  }

  public static String encrypt(String message, String key) throws Exception
  {
    Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
    SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
    IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
    cipher.init(1, secretKey, iv);
    return new BASE64Encoder().encode(cipher.doFinal(message.getBytes("UTF-8")));
  }

  public static byte[] convertHexString(String ss)
  {
    byte[] digest = new byte[ss.length() / 2];
    for (int i = 0; i < digest.length; i++)
    {
      String byteString = ss.substring(2 * i, 2 * i + 1);
      int byteValue = Integer.parseInt(byteString, 8);
      digest[i] = (byte)byteValue;
    }
    return digest;
  }

  public static void main(String[] args)
    throws Exception
  {

    String str ;//=  decrypt("ki1JvW2nfvvPWeGnsFmJT0sL1t4JIHgS","3ring");
    str = decrypt("Thu,22 Oct 2015 12:50:01", "41ccb18fcd5c7118");
    System.out.println(str);

    //System.out.println(encrypt("Thu,22 Oct 2015 12:50:01", "3455df243455df24"));
  }
}