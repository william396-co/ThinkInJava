package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import static com.thinkinjava.util.Print.*;

public class RecoverCADState {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
        List<Class<?extends Shape>> shapeTypes =
                (List<Class<?extends Shape>>)in.readObject();

        Line.deserializeStaticState(in);
        List<Shape> shapeList = (List<Shape>)in.readObject();
        println(shapeList);
    }
}
