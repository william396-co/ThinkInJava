package com.Utils2;

import java.io.PrintStream;
import org.apache.log4j.Logger;

public class DesTool
{
  private static Inner inner = Inner.getInstance();
  private static Logger logger = Logger.getLogger("Deshandler");

  public static synchronized byte[] decrypt(byte[] b)
  {
    try
    {
      return inner.decrypt(b);
    } catch (Exception ex) {
      logger.error("3DES���ܳ��,", ex);
    }return null;
  }

  public static synchronized String decrypt(String strIn)
  {
    try
    {
      return new String(decrypt(HexUtils.fromHexString(strIn)));
    } catch (Exception ex) {
      logger.error("3DES���ܳ��,", ex);
    }return null;
  }

  public static synchronized byte[] encrypt(byte[] arrB)
  {
    try
    {
      return inner.decrypt(arrB);
    } catch (Exception ex) {
      logger.error("3DES���ܳ��,", ex);
    }return null;
  }

  public static void main(String[] args)
  {
    Inner inner = Inner.getInstance();

    System.out.println(encrypt("Thu,22 Oct 2015 12:50:01"));
  }

  public static synchronized String encrypt(String str)
  {
    try
    {
      return inner.encrypt(str);
    } catch (Exception ex) {
      ex.printStackTrace();
      logger.error(ex);
    }return null;
  }

  public static String getKeyStr()
  {
    return inner.getKeyStr();
  }

  public static synchronized void setKeyStr(String keyStr)
  {
    inner.setKeyStr(keyStr);
  }

  public static String getDesStr()
  {
    return inner.getDesStr();
  }

  public static void setDesStr(String desStr)
  {
    inner.setDesStr(desStr);
  }

  public static String getAlgorithm()
  {
    return inner.getAlgorithm();
  }

  public static synchronized void setAlgorithm(String algorithm)
  {
    inner.setAlgorithm(algorithm);
  }

  public static byte[] HexStringToByteArray(String s)
  {
    byte[] buf = new byte[s.length() / 2];
    for (int i = 0; i < buf.length; i++) {
      buf[i] = (byte)(chr2hex(s.substring(i * 2, i * 2 + 1)) * 16 + chr2hex(s.substring(i * 2 + 1, i * 2 + 2)));
    }
    return buf;
  }

  private static byte chr2hex(String chr) {
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
}