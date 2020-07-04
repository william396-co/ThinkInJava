package chapter2;

import java.util.Date;

public class HelloDate {

    public static void main(String[] args) {
        System.out.print("Hello , Today is ");
        System.out.println(new Date());

        System.getProperties().list(System.out);
        System.out.println(System.getProperties().get("user.name"));
        System.out.println(System.getProperties().get("java library.path"));

    }
}
