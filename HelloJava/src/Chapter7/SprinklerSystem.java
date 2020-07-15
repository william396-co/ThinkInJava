package Chapter7;


import static com.thinkinjava.util.Print.*;
class WaterSource
{
    private String s;
    WaterSource()
    {
        println("WaterSource()");
        s ="Contructed";
    }
    public String toString(){return s;}
}

public class SprinklerSystem {

    private String value1,value2,value3,value4;
    private WaterSource source = new WaterSource();
    private  int i;
    private float f;
    public String toString()
    {
        return "value1 = " + value1 + " " +
                "value2 = " + value2 + " " +
                "value3 = " + value3 + " " +
                "value4 = " + value4 + "\n" +
                "i = " + i + " " + "f = " + f + " " +
                "source = " + source;
    }

    public static void main(String[] args) {

        SprinklerSystem sprinkler = new SprinklerSystem();
        print(sprinkler);
    }
}
