package generics;

import static com.thinkinjava.util.Print.*;

public class GenericMethods {

    public <T> void f(T x)
    {
        println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0f);
        gm.f('c');
        gm.f(gm);
    }
}
