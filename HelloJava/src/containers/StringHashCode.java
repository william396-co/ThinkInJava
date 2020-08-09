package containers;

import static com.thinkinjava.util.Print.*;
public class StringHashCode {

    public static void main(String[] args) {
        String[] hellos = "Hello Hello".split(" ");
        println(hellos[0].hashCode());
        println(hellos[1].hashCode());
    }
}
