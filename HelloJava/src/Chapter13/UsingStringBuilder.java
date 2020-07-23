package Chapter13;


import java.util.Random;
import static com.thinkinjava.util.Print.*;

public class UsingStringBuilder {
    public static Random rand = new Random(19);
    public String toString()
    {
        StringBuilder result = new StringBuilder("[");
        for(int i=0;i < 25;i++)
        {
            result.append(rand.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length()-2,result.length());
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        UsingStringBuilder usb = new UsingStringBuilder();
        println(usb);
    }
}
