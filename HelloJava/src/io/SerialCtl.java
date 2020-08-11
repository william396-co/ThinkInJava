package io;

import java.io.*;

import static com.thinkinjava.util.Print.*;


public class SerialCtl {

    private String a;
    private transient String b;

    public SerialCtl(String aa, String bb) {
        a = "Not Transient: " + aa;
        b = "Transient: " + bb;
    }

    public String toString() {
        return a + "\n" + b;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(b);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        b = (String) stream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SerialCtl sc = new SerialCtl("Test1", "Test2");
        println("Before:\n" + sc);

        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buff);
        o.writeObject(sc);


        //Now get it back
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buff.toByteArray()));
        SerialCtl sc2 = (io.SerialCtl) in.readObject();
        println("After:\n" + sc2);

    }

}
