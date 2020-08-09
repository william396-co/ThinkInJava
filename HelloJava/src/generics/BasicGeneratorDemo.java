package generics;

import com.thinkinjava.util.Generator;

import static com.thinkinjava.util.Print.*;


public class BasicGeneratorDemo {

    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);

        for(int i =0; i < 5;i++)
            println(gen.next());
    }
}
