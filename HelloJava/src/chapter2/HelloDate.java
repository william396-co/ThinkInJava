package Chapter2;

// Chapter2/HelloDate.java
import java.util.Date;


/**
 * This is first Thinking in java example program.
 * Display a string and today's date
 * @author william
 * @author www.will.net
 * @version 1.0
 */
public class HelloDate {

    public static void main(String[] args) {
        System.out.print("Hello , Today is ");
        System.out.println(new Date());

        System.getProperties().list(System.out);
        System.out.println(System.getProperties().get("user.name"));
        System.out.println(System.getProperties().get("java library.path"));

    }
}
