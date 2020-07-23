package Chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static com.thinkinjava.util.Print.*;

class MethodSelector implements InvocationHandler
{
    private Object proxied;
    public MethodSelector(Object proxied)
    {
        this.proxied =proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("interesting"))
            println("Proxy detected the interesting method");
        return method.invoke(proxied, args);
    }
}

interface SomeMethods
{
    void boring1();
    void boring2();
    void interesting(String arg);
    void boring3();
}

class Implemetation implements SomeMethods
{

    @Override
    public void boring1() {
        println("boring1");
    }

    @Override
    public void boring2() {
        println("boring2");
    }

    @Override
    public void interesting(String arg) {
        println("interesting " + arg);
    }

    @Override
    public void boring3() {
        println("boring3");
    }
}

public class SelectingMethods {
    public static void main(String[] args) {
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new MethodSelector(new Implemetation()));

        proxy.boring1();
        proxy.boring2();
        proxy.boring3();
        proxy.interesting("bobo");
    }
}
