package Chapter5;

import static com.thinkinjava.util.Print.*;

class Window {
    Window(int marker) {
        println("Window(" + marker + ")");
    }
}

class House
{
    Window w1  = new Window(1);
    House()
    {
        println("House()");
        w3 = new Window(33);
    }
    Window w2=  new Window(2);
    void f()
    {
        println("f()");
    }
    Window w3=  new Window(3);
}


public class OrderOfInitialization {

    public static void main(String[] args) {

        House h = new House();
        h.f();
    }
}
