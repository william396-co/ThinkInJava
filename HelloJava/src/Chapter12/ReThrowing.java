package Chapter12;

import static com.thinkinjava.util.Print.*;

public class ReThrowing {

    public static void f() throws Exception
    {
        println("originating the exception in f()");
        throw new Exception();
    }
    public static void g() throws Exception
    {
        try
        {
            f();
        }
        catch (Exception e)
        {
            println("Inside g(), e.printStackTrace()");
            e.printStackTrace(System.out);
            throw e;
        }
    }

    public static void h() throws Exception
    {
        try
        {
            f();
        }
        catch (Exception e)
        {
            println("Inside h(), e.printStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception)e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try
        {
            g();
        }
        catch (Exception e)
        {
            println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }

        try
        {
            h();
        }
        catch (Exception e)
        {
            println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
    }
}
