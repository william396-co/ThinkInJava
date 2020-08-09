package Chapter14;

import static com.thinkinjava.util.Print.*;

import java.util.regex.*;
import java.lang.reflect.*;

public class ShowMethods {

    private static String usage =
            "usage:\n" +
                    "ShowMethods qualified.class name\n" +
                    "To show all methods in class or :\n" +
                    "ShowMethods qualified.class.name word\n" +
                    "To Search for methods involving 'word'";
    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            println(usage);
            System.exit(0);
        }

        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods)
                    println(p.matcher(method.toString()).replaceAll(""));
                for (Constructor ctor : ctors)
                    println(p.matcher(ctor.toString()).replaceAll(""));
                lines = methods.length + ctors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().indexOf(args[1]) != -1) {
                        println(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                }
                for (Constructor ctor : ctors) {
                    if (ctor.toString().indexOf(args[1]) != -1) {
                        println(p.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            println("No Such class: " + e);
        }
    }

}
