package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.thinkinjava.util.Print.*;

class BerylliumSphere
{
    private static long counter = 0;
    private final long id = counter++;
    public String toString(){return "Sphere " +id;}
}


public class ContainerComparison {
    public static void main(String[] args) {


        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for(int i = 0; i < 5; i++)
            spheres[i] = new BerylliumSphere();

        println(Arrays.toString(spheres));
        println(spheres[4]);


        List<BerylliumSphere> sphereList = new ArrayList<BerylliumSphere>();
        for(int i = 0; i < 5;i++)
            sphereList.add(new BerylliumSphere());

        println(sphereList);
        println(sphereList.get(4));

        int[] ints = {0,1,2,3,4,5,6,7,8};
        println(Arrays.toString(ints));
        println(ints[4]);


        List<Integer> integerList = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7));
        integerList.add(98);
        println(integerList);
        println(integerList.get(4));



    }
}
