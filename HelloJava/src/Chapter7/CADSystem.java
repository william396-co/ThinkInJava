package Chapter7;

import static com.thinkinjava.util.Print.*;

class Shape {
    Shape(int i) {
        println("Shape Constructor");
    }

    void dispose() {
        println("Shape Dispose");
    }
}

class Circle extends Shape {

    Circle(int i) {
        super(i);
        println("Circle Constructor");
    }

    void dispose() {
        println("Circle Dispose");
    }
}

class Triangle extends Shape {

    Triangle(int i) {
        super(i);
        println("Triangle Constructor");
    }

    void dispose() {
        println("Triangle Dispose");
    }
}

class Line extends Shape {
    private int start, end;

    Line(int start, int end) {
        super(start);
        this.start = start;
        this.end = end;
        println("Drawing line: " + start + ", " + end);
    }

    void dispose() {
        println("Erasing Line:" + start + ", " + end);
        super.dispose();
    }
}

public class CADSystem extends Shape {
    private Circle c;
    private Triangle t;
    private Line[] lines = new Line[3];
    public CADSystem(int i)
    {
        super(i+1);
        for(int j = 0; j < lines.length;j++)
            lines[j]=new Line(j,j*j);
        c = new Circle(1);
        t = new Triangle(1);
        println("Combined Constructor");
    }

    public void dispose()
    {
        println("CADSystem dispose");
        t.dispose();
        c.dispose();
        for(int i =0; i < lines.length;i++)
            lines[i].dispose();
        super.dispose();
    }

    public static void main(String[] args) {
        CADSystem x = new CADSystem(57);
        try
        {

        }
        finally {
            x.dispose();
        }
    }
}
