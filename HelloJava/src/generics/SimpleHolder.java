package generics;

import generics.coffee.Americano;
import generics.coffee.Coffee;

import static com.thinkinjava.util.Print.*;

public class SimpleHolder {
    private Object obj;
    public void set(Object obj){this.obj = obj;}
    public Object get(){return obj;}

    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.set("Item");
        String s = (String)holder.get();

        println(holder.get());
        println(s);

        holder.set(new Americano());
        println(holder.get());

    }
}
