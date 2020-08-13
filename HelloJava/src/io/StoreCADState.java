package io;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static com.thinkinjava.util.Print.*;

abstract class Shape implements Serializable{
    public static final int RED = 1, BLUE = 2,GREEN = 3;
    private int xPos,yPos,dimension;
    private static Random rand  = new Random();
    private static int counter =0;
    public abstract void setColor(int newColor);
    public abstract int getColor();
    public Shape(int xVal,int yVal,int dim)
    {
        xPos = xVal;
        yPos = yVal;
        dimension = dim;
    }
    public String toString()
    {
        return getClass()+"color[" + getColor()+"] xPos["+xPos+
                "] yPos["+yPos+"] dim["+dimension+"]\n";
    }

    public static Shape randomFactory()
    {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++%3)
        {
            default:
            case 0:return new Circle(xVal,yVal,dim);
            case 1:return new Square(xVal,yVal,dim);
            case 2:return new Line(xVal,yVal,dim);
        }
    }
}

class Circle extends Shape
{
    private static int Color = RED;
    public Circle(int xVal,int yVal,int dim)
    {
        super(xVal,yVal,dim);
    }

    @Override
    public void setColor(int newColor) {
        Color = newColor;
    }

    @Override
    public int getColor() {
        return Color;
    }
}

class Square extends Shape
{
    private static int Color;
    public Square(int xVal,int yVal,int dim)
    {
        super(xVal,yVal,dim);
        Color = RED;
    }

    @Override
    public void setColor(int newColor) {
        Color = newColor;
    }

    @Override
    public int getColor() {
        return Color;
    }
}

class Line extends Shape
{
    private static int Color = RED;
    public static void serializeStaticState(ObjectOutputStream os) throws IOException
    {
        os.writeObject(Color);
    }
    public static void deserializeStaticState(ObjectInputStream is) throws IOException, ClassNotFoundException {
        Color = (int)is.readObject();
    }

    public Line(int xVal,int yVal,int dim)
    {
        super(xVal,yVal,dim);
    }

    @Override
    public void setColor(int newColor) {
        Color = newColor;
    }

    @Override
    public int getColor() {
        return Color;
    }

}



public class StoreCADState {

    public static void main(String[] args) throws IOException {
        List<Class<? extends Shape>> shapeTypes =
                new ArrayList<Class<? extends Shape>>();
        shapeTypes.add(Circle.class);
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);

        List<Shape> shapes = new ArrayList<Shape>();

        for(int i =0; i < 10;i++)
            shapes.add(Shape.randomFactory());

        for(int i =0; i < 10;i++)
            ((Shape)shapes.get(i)).setColor(Shape.GREEN);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
        out.writeObject(shapeTypes);
        Line.serializeStaticState(out);
        out.writeObject(shapes);
        println(shapes);

    }
}
