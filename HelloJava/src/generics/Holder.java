package generics;


import static com.thinkinjava.util.Print.*;

public class Holder<T> {

    private T value;
    public Holder(){}
    public Holder(T value){this.value = value;}
    public void set(T value){this.value = value;}
    public T get(){return  value;}
    public boolean equals(Object obj)
    {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> appleHolder = new Holder<Apple>(new Apple());
        Apple d = appleHolder.get();
        appleHolder.set(d);

       /* Holder<? extends Fruit> fruitHolder =*/
    }
}
