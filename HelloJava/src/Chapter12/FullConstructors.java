package Chapter12;

import static com.thinkinjava.util.Print.*;

class MyException extends Exception
{
    public MyException(){}
    public MyException(String msg){
        super(msg);
    }
}

public class FullConstructors {
    public static void f()throws MyException
    {
        println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException
    {
        println("Throwing MyException in g()");
        throw new MyException();
    }

    public static void main(String[] args) {
        try
        {
            f();
        }
        catch (MyException e)
        {
            e.printStackTrace(System.out);
        }

        try
        {
            g();
        }
        catch (MyException e)
        {
            e.printStackTrace(System.out);
        }
    }

}
