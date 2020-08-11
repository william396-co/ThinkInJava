package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class FreezeAlien {
    public static void main(String[] args) throws IOException {
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("x.file"));
        Alien quellek= new Alien();
        out.writeObject(quellek);
    }
}
