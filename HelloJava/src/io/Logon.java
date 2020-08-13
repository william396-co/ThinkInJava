package io;

import java.io.*;
import java.nio.LongBuffer;
import java.util.Date;

import static com.thinkinjava.util.Print.*;

public class Logon  implements Serializable {

    private Date date = new Date();
    private String username;
    private transient String password;
    public Logon(String name,String pwd)
    {
        username = name;
        password = pwd;
    }
    public String toString()
    {
        return "logon info\n username: " +username+"\n date: " + date+"\n password: "+password;
    }

    public static void main(String[] args) throws IOException ,ClassNotFoundException{

        Logon a = new Logon("Hulk","mylittlePony");
        println("logon a = " +a);

        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon.out"));
        o.writeObject(a);
        o.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
        println("Recovering object at " + new Date());
        a =(Logon)in.readObject();
        println("logon a = " +a);
    }
}
