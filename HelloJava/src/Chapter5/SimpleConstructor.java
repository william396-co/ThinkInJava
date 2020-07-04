package Chapter5;

import static com.thinkinjava.util.Print.*;

class Rock {
    Rock() {
        print("Rock");
    }
}

class Rock2{
    Rock2(int i)
    {
        println("Rock2"+i);
    }
}

public class SimpleConstructor {

    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            new Rock();
        }


        for (int i = 0; i < 5; ++i) {
            new Rock2(i);
        }
    }
}
