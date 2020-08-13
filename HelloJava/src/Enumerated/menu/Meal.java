package Enumerated.menu;

import static com.thinkinjava.util.Print.*;

public class Meal {
    public static void main(String[] args) {

        for(int i = 0; i < 5; i++)
        {
            for(Course course: Course.values())
            {
                Food food = course.randomSelection();
                println(food);
            }
            println("-----------------------------");
        }
    }
}
