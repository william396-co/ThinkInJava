package com.thinkinjava.util;


import java.io.PrintStream;

public class Print {


    // Print with a newline:
    public static void println(Object obj) {
        System.out.println(obj);
    }
    public static void print(Object obj) {
        System.out.print(obj);
    }
    // Print a newline by itself:
    public static void println() {
        System.out.println();
    }

    // The new Java SE5 printf() (from C):
    public static PrintStream
    printf(String format, Object... args) {
        return System.out.printf(format, args);
    }

/*
    public static void println()    {     System.out.println();    }
    public static void print(double d) {
        System.out.print(d);
    }

    public static void println(double d) {
        System.out.println(d);
    }

    public static void print(Object obj) {
        System.out.print(obj);
    }

    public static void println(Object obj) {
        System.out.println(obj);
    }

    public static void print(char s[]) {
        System.out.print(s);
    }

    public static void println(char s[]) {
        System.out.println(s);
    }

    public static void print(boolean b) {
        System.out.print(b);
    }

    public static void println(boolean b) {
        System.out.println(b);
    }

    public static void print(char c) {
        System.out.print(c);
    }

    public static void println(char c) {
        System.out.println(c);
    }

    public static void print(long l) {
        System.out.print(l);
    }

    public static void println(long l) {
        System.out.println(l);
    }

    public static void print(String s) {
        System.out.print(s);
    }

    public static void println(String s) {
        System.out.println(s);
    }

    public static void print(int x) {
        System.out.print(x);
    }

    public static void print(float x) {
        System.out.print(x);
    }

    public static void println(int x) {
        System.out.println(x);
    }

    private static void println(float x) {
        System.out.println(x);
    }*/
}
