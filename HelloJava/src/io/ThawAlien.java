package io;

import java.io.*;

import static com.thinkinjava.util.Print.*;

public class ThawAlien {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(new File(".","x.file")));
        Object mystery = in.readObject();
        println(mystery.getClass());

    }
}
