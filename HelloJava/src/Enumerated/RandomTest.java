package Enumerated;

import static com.thinkinjava.util.Print.*;

enum Activity {SITTING, LYING, STANDING, HOPPING, RUNNING, DODGING, JUMPING, FALLING, FLYING}

public class RandomTest {
    public static void main(String[] arg)
    {
        for(int i =0;i < 20;i++)
            println(Enums.random(Activity.class) +" ");
    }
}
