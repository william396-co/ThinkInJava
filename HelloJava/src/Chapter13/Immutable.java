package Chapter13;

import static com.thinkinjava.util.Print.*;

public class Immutable {
    public static String upcase(String s)
    {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howd";
        println(q);
        String qq = upcase(q);
        println(qq);
        println(q);
    }
}
