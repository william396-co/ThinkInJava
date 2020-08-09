package arrays;


import java.util.Arrays;

import static com.thinkinjava.util.Print.*;


public class ArrayOptions {

    public static void main(String[] args) {
        BerylliumSphere[] a;
        BerylliumSphere[] b = new BerylliumSphere[5];

        println("b:" + Arrays.toString(b));
        BerylliumSphere[] c = new BerylliumSphere[4];
        for(int i =0; i < c.length;i++)
        {
            if(c[i] == null)
                c[i] = new BerylliumSphere();
        }

        BerylliumSphere[] d = {new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};

        a = new BerylliumSphere[]{
                new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()
        };

        println("a.length = " + a.length);
        println("b.length = " + b.length);
        println("c.length = " + c.length);
        println("d.length = " + d.length);

    }
}
