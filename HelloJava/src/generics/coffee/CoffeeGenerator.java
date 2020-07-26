package generics.coffee;


import java.util.Iterator;
import java.util.Random;

import static com.thinkinjava.util.Print.*;

import com.thinkinjava.util.Generator;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};
    private static Random rand = new Random();
    private int size = 0;

    public CoffeeGenerator() {
    }

    public CoffeeGenerator(int sz) {
        size = sz;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        private int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++)
            println(gen.next());
        for (Coffee c : new CoffeeGenerator(5))
            println(c);
    }
}
