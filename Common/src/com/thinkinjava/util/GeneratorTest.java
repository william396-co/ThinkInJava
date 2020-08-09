package com.thinkinjava.util;

import static com.thinkinjava.util.Print.*;
public class GeneratorTest {

    public static int SIZE = 10;
    public static void test(Class<?> surroundingClass)
    {
        for(Class<?> type: surroundingClass.getClasses())
        {
            print(type.getSimpleName() + ": ");
            try
            {
                Generator<?> g = (Generator<?>)type.newInstance();
                for(int i = 0; i < SIZE; i++)
                    print(g.next()+" ");
                println();
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        test(CountingGenerator.class);
    }
}
