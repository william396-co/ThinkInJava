package Chapter9;

import static com.thinkinjava.util.Print.*;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class RandomWords implements Readable {

    private static Random rand = new Random(55);
    private static final char[]  capitals = "ABCDEFGHIJKLMNopQRSTUVWXYZ".toCharArray();
    private static final char[]  lowers =   "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[]  vowels = "aeiou".toCharArray();
    private int Count;
    public RandomWords(int count){Count = count;}

    @Override
    public int read(CharBuffer cb) throws IOException {
        if(Count==0)
            return  -1;
        cb.append(capitals[rand.nextInt(capitals.length)]);
        for(int i=0;i < 4;i++)
        {
            cb.append(vowels[rand.nextInt(vowels.length)]);
            cb.append(lowers[rand.nextInt(lowers.length)]);
        }
        cb.append(" ");

        return 10;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomWords(10));
        while(s.hasNext())
            println(s.next());
    }
}
