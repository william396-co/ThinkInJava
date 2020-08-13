package Enumerated;

import static com.thinkinjava.util.Print.*;

enum Shrubbery {GROUND,CRAWLING,HANGING}

public class EnumClass {

    public static void main(String[] args) {

        for(Shrubbery s: Shrubbery.values())
        {
            println(s+" ordinal: "+ s.ordinal());
            print(s.compareTo(Shrubbery.CRAWLING) +" ");
            print(s.equals(Shrubbery.CRAWLING) + " ");
            println(s==Shrubbery.CRAWLING);
            println(s.getDeclaringClass());
            println(s.name());
            println("----------------------");
        }

        for(String s: "HANGING CRAWLING GROUND".split(" "))
        {
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class,s);
            println(shrubbery);
        }
    }
}
