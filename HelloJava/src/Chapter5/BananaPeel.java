package Chapter5;

import static com.thinkinjava.util.Print.*;

class Banana {
    public void peel(int i) {
        println("Banana peel:" + i);
    }
}

public class BananaPeel {

    public static void main(String[] args) {

        Banana a = new Banana(),
                b = new Banana();

        a.peel(1);
        b.peel(2);
    }
}
