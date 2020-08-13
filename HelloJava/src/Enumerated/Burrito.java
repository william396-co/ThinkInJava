package Enumerated;

import static com.thinkinjava.util.Print.*;
import static Enumerated.Spinciness.*;


public class Burrito {
    Spinciness degree;
    public Burrito(Spinciness degree){this.degree = degree;}
    public String toString(){return  "Burrito is " + degree;}

    public static void main(String[] args) {
        println(new Burrito(NOT));
        println(new Burrito(MEDIUM));
        println(new Burrito(HOT));
    }
}
