package Chapter3;

import com.thinkinjava.util.Print;

public class ShortCircuit {


    static boolean test1(int val) {
        Print.print(val);
        return true;
    }

    static boolean test2(int val) {
        System.out.print("test2(" + val + ")");
        System.out.print("result:" + (val < 3));
        return val < 3;
    }

    static boolean test3(int val) {
        System.out.print("test3(" + val + ")");
        System.out.print("result:" + (val > 5));
        return val > 5;
    }


    public static void main(String[] args) {

        test1(100);

        boolean b = test1(1)&&test2(2)&&test3(200);
        System.out.print("expression is "+b);
    }
}
