package Chapter11;

import java.lang.reflect.Array;
import java.util.*;

import static com.thinkinjava.util.Print.*;

public class MultiIterableClass extends  IterableClass{

    public Iterable<String> reversed()
    {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {

                    int current = words.length-1;
                    @Override
                    public boolean hasNext() {
                        return current>-1;
                    }

                    @Override
                    public String next() {
                        return words[current--];
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<String> randomized()
    {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                List<String> shuffled = new ArrayList<String>(Arrays.asList(words));
                Collections.shuffle(shuffled,new Random(45));
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        MultiIterableClass mic = new MultiIterableClass();
        for(String s: mic.reversed())
            print(s+" ");
        println();

        for(String s: mic.randomized())
            print(s+" ");
        println();

        for(String s: mic)
            print(s+" ");
    }

}
