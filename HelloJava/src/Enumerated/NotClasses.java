package Enumerated;

import static com.thinkinjava.util.Print.*;


enum LikeClasses
{
    WINKEN{void behavior()
    {
        println("Behavior1");
    }},
    BLINKEN{void behavior()
    {
        println("Behavior2");
    }},
    NOD{void behavior(){
        println("Behavior3");
    }};
    abstract void behavior();
}

public class NotClasses {

}
