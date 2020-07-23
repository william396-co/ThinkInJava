package Chapter14;

import Chapter8.Transmogrify;

import java.util.Arrays;
import java.util.List;

import static com.thinkinjava.util.Print.*;

abstract class Shape
{
    void draw(){println(this+".draw()");}
    abstract public String toString();
}

class Circle extends Shape
{
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square  extends Shape
{
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape
{

    @Override
    public String toString() {
        return "Triangle";
    }
}


public class Shapes {

    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(),new Square(),new Triangle());
        for (Shape shape: shapeList
             ) {
            shape.draw();

        }
    }
}
