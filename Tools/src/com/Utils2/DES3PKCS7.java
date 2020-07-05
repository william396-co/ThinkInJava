package com.Utils2;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DES3PKCS7
{
  private static final String Algorithm = "DESede";

  public static void main(String[] args)
  {
    try
    {
      System.out.println(encrypt3DES("Thu,22 Oct 2015 12:50:01", "41ccb18fcd5c7118").equals("nrh5OHjjnYEcviyJ4wuXV1Y3DlopqJLOYP4XioD1qmo="));
      System.out.println(decrypt3DES("nrh5OHjjnYEcviyJ4wuXV1Y3DlopqJLOYP4XioD1qmo=", "41ccb18fcd5c7118"));
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String encrypt3DES(String value, String key)
    throws Exception
  {
    String str = byte2Base64(encryptMode(getKeyBytes(key), value.getBytes()));
    return str;
  }

  public static String decrypt3DES(String value, String key) throws Exception
  {
    byte[] b = decryptMode(getKeyBytes(key), Base64.decode(value));
    return new String(b);
  }

  public static byte[] getKeyBytes(String strKey)
    throws Exception
  {
    if ((null == strKey) || (strKey.length() < 1)) {
      throw new Exception("key is null or empty!");
    }
    MessageDigest alg = MessageDigest.getInstance("MD5");
    alg.update(strKey.getBytes());
    byte[] bkey = alg.digest();

    int start = bkey.length;
    byte[] bkey24 = new byte[24];
    for (int i = 0; i < start; i++)
    {
      bkey24[i] = bkey[i];
    }
    for (int i = start; i < 24; i++) {
      bkey24[i] = bkey[(i - start)];
    }

    return bkey24;
  }

  public static String byte2hex(byte[] b)
  {
    String hs = "";
    String stmp = "";

    for (int n = 0; n < b.length; n++)
    {
      stmp = Integer.toHexString(b[n] & 0xFF);

      if (stmp.length() == 1)
        hs = hs + "0" + stmp;
      else {
        hs = hs + stmp;
      }
      if (n < b.length - 1) {
        hs = hs + ":";
      }
    }
    return hs.toUpperCase();
  }

  public static String byte2Base64(byte[] b)
  {
    return Base64.encode(b);
  }

  public static byte[] encryptMode(byte[] keybyte, byte[] src)
  {
    try
    {
      SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
      Cipher c1 = Cipher.getInstance("DESede");
      c1.init(1, deskey);

      return c1.doFinal(src);
    } catch (NoSuchAlgorithmException e1) {
      e1.printStackTrace();
    } catch (NoSuchPaddingException e2) {
      e2.printStackTrace();
    } catch (Exception e3) {
      e3.printStackTrace();
    }

    return null;
  }

  public static byte[] decryptMode(byte[] keybyte, byte[] src)
  {
    try {
      SecretKey deskey = new SecretKeySpec(keybyte, "DESede");

      Cipher c1 = Cipher.getInstance("DESede");
      c1.init(2, deskey);
      return c1.doFinal(src);
    }
    catch (NoSuchAlgorithmException e1) {
      e1.printStackTrace();
    } catch (NoSuchPaddingException e2) {
      e2.printStackTrace();
    } catch (Exception e3) {
      e3.printStackTrace();
    }

    return null;
  }
}