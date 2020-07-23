package Chapter12;

import static com.thinkinjava.util.Print.*;

public class ExceptionMethods {

    public static void main(String[] args) {
        try
        {
            throw new Exception("My Exception");
        }
        catch (Exception e)
        {
            println("Caught Exception");
            println("getMessage():"+e.getMessage());
            println("getLocalizedMessage():"+e.getLocalizedMessage());
            println("toString():"+e);
            print("printStackTrace():");
            e.printStackTrace(System.out);
        }
    }
}
