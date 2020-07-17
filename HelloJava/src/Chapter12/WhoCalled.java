package Chapter12;

import static com.thinkinjava.util.Print.*;
public class WhoCalled {

    static void f()
    {
        try
        {
            throw  new Exception();
        }
        catch (Exception e)
        {
            for(StackTraceElement ste: e.getStackTrace())
                println(ste.getMethodName());
        }
    }

    static void g(){f();}
    static void h(){g();}

    public static void main(String[] args) {
        f();
        println("===================");
        g();
        println("===================");
        h();
    }
}
