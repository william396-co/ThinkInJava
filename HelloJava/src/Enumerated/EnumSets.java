package Enumerated;

import java.util.EnumSet;

import static com.thinkinjava.util.Print.*;
import static Enumerated.AlarmPoints.*;

public class EnumSets {

    public static void main(String[] args) {

        EnumSet<AlarmPoints> points =
                EnumSet.noneOf(AlarmPoints.class);
        points.add(BATHROOM);
        println(points);
        points.addAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
        println(points);
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
        println(points);
        points.removeAll(EnumSet.range(OFFICE1,OFFICE4));
        println(points);
        points = EnumSet.complementOf(points);
        println(points);


    }
}
