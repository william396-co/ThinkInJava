package Chapter5;

import static com.thinkinjava.util.Print.*;

class Bird {
};

class Bird2 {
    Bird2(int i) {
        println("Bird2:" + i);
    }

    Bird2(String s) {
        println("Bird2:" + s);
    }

    Bird2(double d) {
        println("Bird2:" + d);
    }
}

public class DefaultConstructor {

    public static void main(String[] args) {
        Bird b = new Bird();

        Bird2 b2 = new Bird2(3);
        Bird2 b3 = new Bird2(4.5);
        Bird2 b4 = new Bird2("Hello");
    }
}
