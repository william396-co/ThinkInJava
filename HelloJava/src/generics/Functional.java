package generics;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.thinkinjava.util.Print.*;


interface Combiner<T> {T combine(T x, T y);}
interface UnaryFunction<R,T>{R function(T x);}
interface Collector<T> extends UnaryFunction<T,T>{ T result();}

interface UnaryPredicate<T>{boolean test(T x);}

public class Functional {

    public static <T> T reduce(Iterable<T> seq,Combiner<T> combiner)
    {
        Iterator<T> it = seq.iterator();
        if(it.hasNext())
        {
            T result = it.next();
            while(it.hasNext())
                result = combiner.combine(result,it.next());
            return result;
        }
        return null;
    }

    public static <T> Collector<T> forEach(Iterable<T> seq,Collector<T> func)
    {
        for (T t: seq)
            func.function(t);
        return func;
    }

    public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> pred) {
        List<T> result = new ArrayList<T>();
        for (T t : seq)
            if (pred.test(t))
                result.add(t);
        return result;
    }

    static class IntegerAddr implements Combiner<Integer>
    {

        @Override
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }

    static class IntegerSubtracter implements Combiner<Integer>
    {

        @Override
        public Integer combine(Integer x, Integer y) {
            return x - y ;
        }
    }

    static class BigDecimalAddr implements Combiner<BigDecimal>
    {

        @Override
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }

    static class BigIntegerAddr implements Combiner<BigInteger>
    {

        @Override
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }

    static class AtomicLongAddr implements Combiner<AtomicLong>
    {

        @Override
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }

    static class BigDecimalUlp implements UnaryFunction<BigDecimal,BigDecimal>
    {
        @Override
        public BigDecimal function(BigDecimal x) {
            return x.ulp();
        }
    }
    static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T>
    {
        private T bound;
        public GreaterThan(T bound){this.bound = bound;}
        @Override
        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }

    static class MultiplyingIntegerCollector implements Collector<Integer>
    {
        private int val = 1;

        @Override
        public Integer function(Integer x) {
            val *= x;
            return val;
        }

        @Override
        public Integer result() {
            return val;
        }
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        Integer result = reduce(list,new IntegerAddr());
        println(result);

        result = reduce(list,new IntegerSubtracter());
        println(result);

        println(filter(list,new GreaterThan<Integer>(4)));

        println(forEach(list,new MultiplyingIntegerCollector()).result());


        println(forEach(filter(list,new GreaterThan<Integer>(4)),
                new MultiplyingIntegerCollector()).result());


        List<AtomicLong> lal = Arrays.asList(new AtomicLong(11),
                new AtomicLong(47),new AtomicLong(74),
                new AtomicLong(74),new AtomicLong(133));
        AtomicLong ral = reduce(lal,new AtomicLongAddr());
        println(ral);

    }
}



