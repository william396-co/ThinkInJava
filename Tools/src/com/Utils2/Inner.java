package com.Utils2;

import com.sun.crypto.provider.SunJCE;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

final class Inner
{
  private String keyStr = "41ccb18fcd5c7118";
  private String desStr = "12345678";
  private String algorithm = "DES/CBC/PKCS5Padding";
  private static Inner instance;
  private Key key = getKey(this.keyStr);

  private byte[] desInitValue = HexUtils.strToByte(this.desStr);
  private IvParameterSpec ivspec = new IvParameterSpec(new byte[] { 0, 0, 0, 0, 0, 0, 0, 0 });

  private Cipher encryptCipher = null;

  private Cipher decryptCipher = null;

  static Inner getInstance()
  {
    if (instance == null) {
      synchronized (Inner.class) {
        if (instance == null) {
          Security.addProvider(new SunJCE());
          Security.addProvider(new BouncyCastleProvider());

          instance = new Inner();
        }
      }
    }
    return instance;
  }

  public byte[] encrypt(byte[] arrB)
    throws Exception
  {
    this.encryptCipher = Cipher.getInstance(this.algorithm);
    this.encryptCipher.init(1, this.key, this.ivspec);
    return this.encryptCipher.doFinal(arrB);
  }

  public String encrypt(String strIn)
    throws Exception
  {
    this.encryptCipher = Cipher.getInstance(this.algorithm);
    this.encryptCipher.init(1, this.key, this.ivspec);

    return HexUtils.toHexString(encrypt(strIn.getBytes()));
  }

  public byte[] decrypt(byte[] arrB)
    throws Exception
  {
    this.decryptCipher = Cipher.getInstance(this.algorithm);
    this.decryptCipher.init(2, this.key, this.ivspec);
    return this.decryptCipher.doFinal(arrB);
  }

  public String decrypt(String strIn)
    throws Exception
  {
    return HexUtils.toHexString(decrypt(HexUtils.fromHexString(strIn)));
  }

  private Key getKey(String str) {
    Key key = null;
    try {
      System.out.println(DigestUtils.md5Hex(str.getBytes("UTF-8")));
      key = new SecretKeySpec(DigestUtils.md5(str.getBytes("UTF-8")), this.algorithm);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return key;
  }

  private byte chr2hex(String chr) {
    if (chr.equals("0"))
      return 0;
    if (chr.equals("1"))
      return 1;
    if (chr.equals("2"))
      return 2;
    if (chr.equals("3"))
      return 3;
    if (chr.equals("4"))
      return 4;
    if (chr.equals("5"))
      return 5;
    if (chr.equals("6"))
      return 6;
    if (chr.equals("7"))
      return 7;
    if (chr.equals("8"))
      return 8;
    if (chr.equals("9"))
      return 9;
    if (chr.equals("A"))
      return 10;
    if (chr.equals("B"))
      return 11;
    if (chr.equals("C"))
      return 12;
    if (chr.equals("D"))
      return 13;
    if (chr.equals("E"))
      return 14;
    if (chr.equals("F")) {
      return 15;
    }
    return 0;
  }

  public String getKeyStr() {
    return this.keyStr;
  }

  public void setKeyStr(String keyStr)
  {
    this.keyStr = keyStr;
    this.key = getKey(keyStr);
  }

  public String getDesStr() {
    return this.desStr;
  }

  public void setDesStr(String desStr)
  {
    this.desStr = desStr;
    this.desInitValue = HexUtils.strToByte(this.desStr);
    this.ivspec = new IvParameterSpec(this.desInitValue);
  }

  public String getAlgorithm() {
    return this.algorithm;
  }

  public void setAlgorithm(String algorithm)
  {
    this.algorithm = algorithm;
    this.key = getKey(this.keyStr);
  }

  public static void main(String[] args) throws Exception {

    Inner inner = new Inner();
    inner.setKeyStr("i3ring");
    String str = inner.encrypt("user");
    System.out.println(str);

  }
}