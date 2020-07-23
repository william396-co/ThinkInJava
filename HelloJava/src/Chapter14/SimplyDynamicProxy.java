package Chapter14;

import com.thinkinjava.util.Print.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static com.thinkinjava.util.Print.*;

class DynamicProxyHandler implements InvocationHandler
{
    private Object proxied;
    public DynamicProxyHandler(Object proxied)
    {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        print("**** proxy: " + proxy.getClass() + ", method: " + method+", args: " + args);
        if(args!=null) {
            for (Object arg : args)
                print(" " + arg);
        }
        println();
        return method.invoke(proxied,args);
    }
}

public class SimplyDynamicProxy {

    public static void consumer(Interface iface)
    {
        iface.doSomething();
        iface.somethingElse("bobobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
