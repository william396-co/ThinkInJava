package com.thinkinjava.util;

public class ConvertTo {

    public static boolean[] primitvie(Boolean[] in)
    {
        boolean[] result = new boolean[in.length];
        for(int i =0; i < in.length;i++)
            result[i] = in[i];
        return result;
    }

    public static char[] primitive(Character[] in)
    {
        char[] result = new char[in.length];
        for(int i =0; i < in.length;i++)
            result[i] = in[i];
        return result;
    }

    public static byte[] primitive(Byte[] in)
    {
        byte[] result = new byte[in.length];
        for(int i = 0; i < in.length;i++)
            result[i]=in[i];
        return result;
    }
}
