package generics;


import com.thinkinjava.util.Generator;
import generics.coffee.Americano;
import generics.coffee.Coffee;

import static com.thinkinjava.util.Print.*;

public class GenericHolder<T> {

    private T obj;
    public void set(T obj){this.obj = obj;}
    public T get(){return obj;}

    public static void main(String[] args) {
        GenericHolder<String> holder = new GenericHolder<String>();
        holder.set("Hello");
        println(holder.get());

       // holder.set(new Americano());

        GenericHolder<Coffee> coffeeHolder = new GenericHolder<Coffee>();
        coffeeHolder.set(new Americano());
        println(coffeeHolder.get());

    }

}
