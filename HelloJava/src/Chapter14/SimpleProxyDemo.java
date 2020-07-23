package Chapter14;


import static com.thinkinjava.util.Print.*;

interface Interface
{
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface
{

    @Override
    public void doSomething() {
        println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        println("SomethingElse " + arg);
    }
}

class SimpleProxy implements Interface
{

    private Interface proxied;
    public SimpleProxy(Interface proxied)
    {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        println("SimpleProxy doSomthing");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        println("SimpleProxy SomethingElse " + arg);
        proxied.somethingElse(arg);
    }
}

public class SimpleProxyDemo {
    public static void consumer(Interface iface)
    {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
