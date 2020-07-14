package Chapter9;

import static com.thinkinjava.util.Print.*;

interface Service
{
    void method1();
    void method2();
}

interface ServiceFactory
{
    Service getService();
}

class Implementation1 implements Service
{

    @Override
    public void method1() {
        println("Implementation1 method1");
    }

    @Override
    public void method2() {
        println("Implementation1 method2");

    }
}

class Implementation1Factory implements ServiceFactory
{
    @Override
    public Service getService() {
        return new Implementation1();
    }
}



class Implementation2 implements Service
{

    @Override
    public void method1() {
        println("Implementation2 method1");
    }

    @Override
    public void method2() {
        println("Implementation2 method2");

    }
}

class Implementation2Factory implements ServiceFactory
{
    @Override
    public Service getService() {
        return new Implementation2();
    }
}

public class Factories {

    public static void ServiceConsumer(ServiceFactory fact)
    {
        Service s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        ServiceConsumer(new Implementation1Factory());
        ServiceConsumer(new Implementation2Factory());
    }
}
