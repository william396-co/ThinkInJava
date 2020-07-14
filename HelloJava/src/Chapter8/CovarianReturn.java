package Chapter8;

import static com.thinkinjava.util.Print.*;

class Grain
{
    public String toString()
    {
        return "Grain";
    }
}

class Wheat extends Grain
{
    public String toString()
    {
        return "Wheat";
    }
}

class Mill
{
    Grain process()
    {
        return new Grain();
    }
}

class WheatMill extends Mill
{
    Wheat process()
    {
        return new Wheat();
    }
}



public class CovarianReturn {

    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g= m.process();
        println(g);

        m = new WheatMill();
        g= m.process();
        println(g);
    }
}
