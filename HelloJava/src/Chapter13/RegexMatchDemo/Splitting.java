package Chapter13.RegexMatchDemo;

import java.util.Arrays;

import static com.thinkinjava.util.Print.*;

public class Splitting {

    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";
    public static void split(String regex)
    {
        println(Arrays.toString(knights.split(regex)));
    }
    public static void main(String[] args) {
        split(" ");
        split("\\W+");
        split("n\\W+");

    }
}
