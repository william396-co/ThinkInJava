package Chapter13.RegexMatchDemo;

import static com.thinkinjava.util.Print.*;

public class IntegerMatch {

    public static void main(String[] args) {

        println("-1234".matches("-?\\d+"));
        println("5678".matches("-?\\d+"));
        println("+911".matches("-?\\d+"));
        println("+911".matches("(-|\\+)?\\d+"));

    }
}
