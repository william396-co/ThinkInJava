package Chapter13;

import static com.thinkinjava.util.Print.*;
public class SimpleFormat {

    public static void main(String[] args) {
        int x =9;
        double y = 434.545;
        println("Row 1:["+x+" "+ y+"]");
        System.out.format("Row 1:[%d %f]",x,y);
        println();
        System.out.printf("Row 1:[%d %f]",x,y);
    }
}
