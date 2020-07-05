package com.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.util.ByteArrayBuffer;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DesUtil {
    private static final String tag = "debug";
    private static final Log log = LogFactory.getLog(DesUtil.class);

    public DesUtil() {
    }

    public static byte[] appendIntToByteArrayBuffer(int iSource, int iArrayLen, ByteArrayBuffer buffer) {
        byte[] bLocalArr = new byte[iArrayLen];

        for(int i = 0; i < 4 && i < iArrayLen; ++i) {
            bLocalArr[i] = (byte)(iSource >> 8 * i & 255);
        }

        buffer.append(bLocalArr, 0, bLocalArr.length);
        return bLocalArr;
    }

    public static byte[] appendLongToByteArrayBuffer(long iSource, int iArrayLen, ByteArrayBuffer buffer) {
        byte[] bLocalArr = new byte[iArrayLen];

        for(int i = 0; i < 8 && i < iArrayLen; ++i) {
            bLocalArr[i] = (byte)((int)(iSource >> 8 * i & 255L));
        }

        buffer.append(bLocalArr, 0, bLocalArr.length);
        return bLocalArr;
    }

    public static int byteArrayToInt(byte[] bRefArr) {
        int iOutcome = 0;

        for(int i = 0; i < bRefArr.length; ++i) {
            byte bLoop = bRefArr[i];
            iOutcome += (bLoop & 255) << 8 * i;
        }

        return iOutcome;
    }

    public static long byteArrayToLong(byte[] bRefArr) {
        long lOutcome = 0L;

        for(int i = 0; i < bRefArr.length; ++i) {
            byte bLoop = bRefArr[i];
            lOutcome += (long)((bLoop & 255) << 8 * i);
        }

        return lOutcome;
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src != null && src.length > 0) {
            for(int i = 0; i < src.length; ++i) {
                int v = src[i] & 255;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    stringBuilder.append(0);
                }

                stringBuilder.append(hv);
            }

            return stringBuilder.toString();
        } else {
            return null;
        }
    }

    public static byte[] getMD5Byte(String str) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException var3) {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        } catch (UnsupportedEncodingException var4) {
            var4.printStackTrace();
        }

        byte[] byteArray = messageDigest.digest();
        return byteArray;
    }

    public static String getMD5str(String str) {
        String result = byte2Hex(getMD5Byte(str));
        return result;
    }

    public static String desEncrypt(String src, String key) throws Exception {
        if (src != null && src.length() != 0) {
            log.debug("desEncrypt:" + src);
            DESKeySpec ks = new DESKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
            SecretKey sk = skf.generateSecret(ks);
            Cipher cip = Cipher.getInstance("DES/CBC/PKCS5Padding");
            byte[] IV = key.getBytes("UTF-8");
            IvParameterSpec iv2 = new IvParameterSpec(IV);
            cip.init(1, sk, iv2);
            byte[] input = cip.doFinal(src.getBytes("UTF-8"));
            String dest = byte2Hex(input);
            log.debug("desEncrypt:" + dest);
            return dest;
        } else {
            return new String();
        }
    }

    public static String desDecrypt(String src, String key) throws Exception {
        if (src != null && src.length() != 0) {
            log.debug("deDecrypt:" + src);
            DESKeySpec ks = new DESKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
            SecretKey sk = skf.generateSecret(ks);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            byte[] IV = key.getBytes("UTF-8");
            IvParameterSpec iv2 = new IvParameterSpec(IV);
            cipher.init(2, sk, iv2);
            byte[] data = hex2Byte(src);
            byte[] decryptedData = cipher.doFinal(data);
            String strResult = new String(decryptedData, "UTF-8");
            log.debug("deDecrypt:" + strResult);
            return strResult;
        } else {
            return new String();
        }
    }

    public static String des3Decrypt(String src, String key) throws Exception {
        if (src != null && src.length() != 0) {
            DESKeySpec ks = new DESKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DESede");
            SecretKey sk = skf.generateSecret(ks);
            Cipher cipher = Cipher.getInstance("DESede");
            byte[] IV = key.getBytes("UTF-8");
            IvParameterSpec iv2 = new IvParameterSpec(IV);
            cipher.init(2, sk, iv2);
            byte[] data = hex2Byte(src);
            byte[] decryptedData = cipher.doFinal(data);
            return new String(decryptedData, "UTF-8");
        } else {
            return new String();
        }
    }

    public static String byte2Hex(byte[] b) {
        String hs = "";
        String stmp = "";

        for(int n = 0; n < b.length; ++n) {
            stmp = Integer.toHexString(b[n] & 255);
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }

        return hs.toUpperCase();
    }

    public static byte[] hex2Byte(String hexString) {
        if (hexString.length() % 2 == 1) {
            return null;
        } else {
            byte[] ret = new byte[hexString.length() / 2];

            for(int i = 0; i < hexString.length(); i += 2) {
                ret[i / 2] = Integer.decode("0x" + hexString.substring(i, i + 2)).byteValue();
            }

            return ret;
        }
    }

    public static int stringToByte(String in, byte[] b) throws Exception {
        if (b.length < in.length() / 2) {
            throw new Exception("byte array too small");
        } else {
            int j = 0;
            StringBuffer buf = new StringBuffer(2);

            for(int i = 0; i < in.length(); ++j) {
                buf.insert(0, in.charAt(i));
                buf.insert(1, in.charAt(i + 1));
                int t = Integer.parseInt(buf.toString(), 16);
                System.out.println("byte hex value:" + t);
                b[j] = (byte)t;
                ++i;
                buf.delete(0, 2);
                ++i;
            }

            return j;
        }
    }

    public static String encryption(String plainText) {
        String re_md5 = new String();

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte[] b = md.digest();
            StringBuffer buf = new StringBuffer("");

            for(int offset = 0; offset < b.length; ++offset) {
                int i = b[offset];
                if (i < 0) {
                    i += 256;
                }

                if (i < 16) {
                    buf.append("0");
                }

                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();
        } catch (NoSuchAlgorithmException var7) {
            var7.printStackTrace();
        }

        return re_md5.toUpperCase();
    }

    public static void main(String[] args) {
        String descString = null;

        try
        {

           String str= desEncrypt("user", "1qaz2wsx");
           System.out.println(str);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}