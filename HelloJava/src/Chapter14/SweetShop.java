package Chapter14;

import static com.thinkinjava.util.Print.*;

class Candy {
    static {
        println("Loading Candy");
    }
}

class Gum {
    static {
        println("Loading Gum");
    }
}

class Cookie {
    static {
        println("Loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        println("Inside main");
        new Candy();
        println("After creating Candy");
        try {
            Class.forName("Chapter14.Gum"); //use package name
        } catch (ClassNotFoundException e) {
            println("Couldn't find Gum");
        }
        println("After Class.forName(\"Gum\")");
        new Cookie();
        println("After creating Cookie");
    }
}
