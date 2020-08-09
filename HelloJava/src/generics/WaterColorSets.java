package generics;

import java.util.EnumSet;
import java.util.Set;
import static generics.Sets.*;

import static com.thinkinjava.util.Print.*;

public class WaterColorSets {

    public static void main(String[] args) {
        Set<WaterColors> set1 = EnumSet.range(WaterColors.BRILLIANT_RED,WaterColors.VIRIDIAN_HUE);
        Set<WaterColors> set2 = EnumSet.range(WaterColors.CERULEAN_BLUE_HUE,WaterColors.BURNT_UMBER);

        println("Set1: " + set1);
        println("Set2: " + set2);

        println("union(set1,set1):" + union(set1, set2));

        Set<WaterColors> subset = intersection(set1, set2);
        println("intersection(set1,set2):" + subset);

        println("difference(set1,subset):" + difference(set1, subset));
        println("difference(set1,subset):" + difference(set2, subset));

        println("complement(set1,set2):" + complement(set1, set2));

    }
}
