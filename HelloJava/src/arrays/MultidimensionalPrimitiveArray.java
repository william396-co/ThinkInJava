package arrays;

import java.util.Arrays;

import static com.thinkinjava.util.Print.*;

public class MultidimensionalPrimitiveArray {

    public static void main(String[] args) {
        int[][] a =
                {
                        {1,3,5,7,9},
                        {2,4,6,8,0}
                };
        println(Arrays.deepToString(a));
        println(Arrays.toString(a));

    }
}
