package Chapter7;

import static com.thinkinjava.util.Print.*;

class Art
{
    Art()
    {
        println("Art Constructor");
    }
}

class Drawing extends Art{
    Drawing(){
        println("Draw Constructor");
    }
}

public class Cartoon extends Drawing {

    Cartoon(){
        println("Cartoon Constructor");
    }

    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
}
