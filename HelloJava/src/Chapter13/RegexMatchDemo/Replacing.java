package Chapter13.RegexMatchDemo;

import static com.thinkinjava.util.Print.*;

public class Replacing {
    static String s = Splitting.knights;
    public static void main(String[] args) {
        println(s.replaceFirst("f\\w+","located"));
        println(s.replaceAll("shrubbery|tree|herring","banana"));
    }
}
