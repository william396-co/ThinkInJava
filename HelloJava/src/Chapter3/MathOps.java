package Chapter3;

import java.util.Random;

public class MathOps {

    public static void main(String[] args) {
        Random rand = new Random(47);
        int i, j, k;
        j = rand.nextInt(100) + 1;
        System.out.println("j=" + j);
    }
}
