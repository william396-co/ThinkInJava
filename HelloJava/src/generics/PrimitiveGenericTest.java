package generics;

import com.thinkinjava.util.Generator;

import static com.thinkinjava.util.Print.*;

class FArray
{
    public static <T> T[] fill(T[] a, Generator<T> generator)
    {
        for(int i =0; i < a.length;i++)
            a[i] = generator.next();
        return a;
    }
}

public class PrimitiveGenericTest {

    public static void main(String[] args) {

    }
}
