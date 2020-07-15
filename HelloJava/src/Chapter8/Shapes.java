package Chapter8;

import java.awt.image.SampleModel;
import java.util.Random;

import static com.thinkinjava.util.Print.*;

class Shape
{
    public void draw(){
    }
    public void erase(){}
}

class Circle extends Shape
{
    public void draw(){
        println("Circle draw");
    }
    public void erase(){
        println("Circle erase");}
}

class Square extends Shape
{

    public void draw(){
        println("Square draw");
    }
    public void erase(){
        println("Square erase");}
}

class Triangle extends Shape
{
    public void draw(){
        println("Triangle draw");
    }
    public void erase(){
        println("Triangle erase");}

}

class RandomShapeGenerator
{
    private Random rand = new Random(45);
    public Shape next()
    {
        switch (rand.nextInt(3))
        {
            default:
            case 0: return new Circle();
            case 1: return  new Square();
            case 2: return new Triangle();
        }
    }
}

public class Shapes {

    private static RandomShapeGenerator gen = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] s = new Shape[9];
        for(int i =0; i < s.length;i++)
            s[i] = gen.next();

        for(Shape shp: s)
            shp.draw();
    }
}
