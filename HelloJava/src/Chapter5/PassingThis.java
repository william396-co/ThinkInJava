package Chapter5;

import static com.thinkinjava.util.Print.*;

class Person {
    public void eat(Apple apple) {
        Apple peeled = apple.getPeeled();
        println("Yummy");
    }
}

class Peeler {
    static Apple peel(Apple apple) {
        return apple;
    }
}

class Apple {
    Apple getPeeled() {
        return Peeler.peel(this);
    }
}

public class PassingThis {

    public static void main(String[] args) {

        new Person().eat(new Apple());
    }
}
