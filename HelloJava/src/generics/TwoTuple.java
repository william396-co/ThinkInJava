package generics;

import static com.thinkinjava.util.Print.*;
public class TwoTuple<A,B> {
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {

        TwoTuple<String,Integer> tt = new TwoTuple<String,Integer>("Hello",5);
        println(tt);
    }
}
