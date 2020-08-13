package io;

import java.io.*;

import static com.thinkinjava.util.Print.*;

class Blip1  implements Externalizable {

    public Blip1()
    {
        println("Blip1 Constructor");
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        println("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable
{
    public Blip2()
    {
        println("Blip2 Constructor");
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        println("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        println("Blip2.readExternal");
    }
}

public class Blips
{
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        println("Constructor objects");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();

        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream("Blips.out"));
        println("Saving objects");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();


        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Blips.out"));
        println("Recovering b1:");
        b1 = (Blip1)in.readObject();
        println(b1);
        println("Recovering b2:");
        b2 = (Blip2)in.readObject();
        println(b2);

    }

}


