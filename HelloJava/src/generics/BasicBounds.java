package generics;

import static com.thinkinjava.util.Print.*;

import java.awt.*;
import java.awt.Color.*;

interface HasColor {
    java.awt.Color getColor();
}

class Colored<T extends HasColor>
{
    T item;
    Colored(T item){this.item = item;}
    T getItem(){return item;}

    java.awt.Color Color(){return item.getColor();}
}

class Dimension
{
    public int x, y,z;
}

class ColoredDemension<T extends Dimension & HasColor>
{
    T item;
    ColoredDemension(T item){this.item = item;}
    T getItem(){return item;}
    java.awt.Color color(){return item.getColor();}
    int getX(){return item.x;}
    int getY(){return item.y;}
    int getZ(){return item.z;}
}

interface Weight{int weight();}

class Solid<T extends Dimension & HasColor & Weight>
{
    T item;
    Solid(T item){this.item = item;}
    T getItem(){return item;}
    java.awt.Color color(){return item.getColor();}
    int getX(){return item.x;}
    int getY(){return item.y;}
    int getZ(){return item.z;}
}

class Bounded extends Dimension implements HasColor,Weight
{


    @Override
    public int weight() {
        return 0;
    }

    @Override
    public Color getColor() {
        return java.awt.Color.getColor("0xFF");
    }
}

public class BasicBounds {

    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
        solid.color();
        solid.getY();
       // solid.weight();
    }
}
