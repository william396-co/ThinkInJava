package Chapter5;

import static com.thinkinjava.util.Print.*;


public class Burrito {

    Spiciness degree;
    public Burrito(Spiciness degree){this.degree = degree;}

    public void describe()
    {
        print("This burrito is ");
        switch (degree)
        {

            case NOT:
                println("no spicy at all");
                break;
            case MILD:
            case MEDIUM:
                println("a little hot");
                break;
            case HOT:
            case FLAMING:
                println("maybe too hot");
                break;
        }
    }

    public static void main(String[] args) {
        Burrito plain = new Burrito(Spiciness.NOT),
                greenChile = new Burrito(Spiciness.MEDIUM),
                jalapeno = new Burrito(Spiciness.HOT);
        plain.describe();
        greenChile.describe();
        jalapeno.describe();
    }
}
