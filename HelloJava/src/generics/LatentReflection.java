package generics;

import java.lang.reflect.Method;

import static com.thinkinjava.util.Print.*;

class Mime {
    public void walkAgainstTheWind() {
    }

    public void sit() {
        println("pretending to sit");
    }

    public void pushInvisibleWalls() {
    }

    public String toString() {
        return "Mime";
    }
}

class SmartDog
{
    public void speak(){println("Woof");}
    public void sit(){println("Sitting");}
    public void reproduce(){}
}


class CommunicateReflectively
{
    public static void perform(Object speaker)
    {
        Class<?> spkr = speaker.getClass();
        try
        {
            try
            {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speak);
            }
            catch (NoSuchMethodException e)
            {
                println(speaker + " cannot speak");
            }


            try
            {
                Method sit = spkr.getMethod("sit");
                sit.invoke(speaker);
            }
            catch (NoSuchMethodException e)
            {
                print(speaker+" cannot sit");
            }
        }
        catch (Exception e)
        {
            throw  new RuntimeException(speaker.toString(),e);
        }
    }
}

class Robot{}

public class LatentReflection {

    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        //CommunicateReflectively.perform(new Robot());
       // CommunicateReflectively.perform(new Mime());
    }
}
