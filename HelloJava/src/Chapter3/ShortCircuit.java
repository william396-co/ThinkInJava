package Chapter3;

import com.thinkinjava.util.Print;

public class ShortCircuit {


    public static boolean test1(int val)
    {
        Print.print(val);
        return true;
    }


    public static void main(String[] args) {

        test1(100);
    }
}
