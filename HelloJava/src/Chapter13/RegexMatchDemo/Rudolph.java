package Chapter13.RegexMatchDemo;

import static com.thinkinjava.util.Print.*;

public class Rudolph {

    public static void main(String[] args) {
        for(String pattern: new String[]{"Rudolph","[rR]udolph","[rR][aeiou][a-z]ol.*","R.*"})
            println("Rudolph".matches(pattern));
    }
}
