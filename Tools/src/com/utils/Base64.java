package com.utils;

import java.lang.reflect.Method;

public class Base64 {
    public Base64() {
    }

    public static String encodeBase64(byte[] input) throws Exception {
        Class<?> clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
        Method mainMethod = clazz.getMethod("encode", byte[].class);
        mainMethod.setAccessible(true);
        Object retObj = mainMethod.invoke((Object)null, input);
        return (String)retObj;
    }

    public static byte[] decodeBase64(String input) throws Exception {
        Class<?> clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
        Method mainMethod = clazz.getMethod("decode", String.class);
        mainMethod.setAccessible(true);
        Object retObj = mainMethod.invoke((Object)null, input);
        return (byte[])((byte[])retObj);
    }

}