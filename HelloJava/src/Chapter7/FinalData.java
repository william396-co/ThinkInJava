package Chapter7;

import java.util.Random;

import static com.thinkinjava.util.Print.*;

class Value
{
    int i;
    public Value(int i){this.i =i;}
}

public class FinalData {
    private static Random rand = new Random(100);
    private String id;
    public FinalData(String id){this.id = id;}

    private final  int valueOne =9;
    private static final int VALUE_TWO = 99;

    public static final int VALUE_THREE = 39;

    private final int INT_5 = rand.nextInt(32);

}
