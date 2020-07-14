package Chapter10;

import sun.security.krb5.internal.crypto.Des;

import static com.thinkinjava.util.Print.*;

public class Parcell {

    class Contents
    {
        private int i = 11;
        public int value(){return i;}
    }
    class Destination
    {
        private String label;
        Destination(String whereTo)
        {
            label = whereTo;
        }
        String readLabel(){return label;}
    }
    public void ship(String dest)
    {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcell p = new Parcell();
        p.ship("Tasmania");
    }
}
