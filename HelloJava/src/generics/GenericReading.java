package generics;

import java.util.Arrays;
import java.util.List;

import static com.thinkinjava.util.Print.*;


public class GenericReading {

    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruits = Arrays.asList(new Fruit());

    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruits);

        f = readExact(apples);
    }

    static class Reader<T>
    {
        T readExact(List<T> list){return list.get(0);}
    }

    static void f2()
    {
        Reader<Fruit>  fruitReader = new Reader<Fruit>();
        Fruit f = fruitReader.readExact(fruits);
    }

    static class ConvariantReader<T>{
        T readConvariant(List<? extends  T>list)
        {
            return list.get(0);
        }
    }

    static void f3()
    {
        ConvariantReader<Fruit> fruitConvariantReader = new ConvariantReader<Fruit>();

        Fruit f = fruitConvariantReader.readConvariant(fruits);
        Fruit a = fruitConvariantReader.readConvariant(apples);
    }


    public static void main(String[] args) {
        f1();
        f2();
        f3();
    }
}
