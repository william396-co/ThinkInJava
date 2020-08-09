package generics;


import java.util.*;

import static com.thinkinjava.util.Print.*;

class Frob{}
class Fnorkle{}
class Quark<Q>{}
class Particle<POSITION,MOMENT>{}

public class LostInformation {

    public static void main(String[] args) {

        List<Frob> list = new ArrayList<Frob>();
        Map<Frob, Fnorkle> map = new HashMap<Frob, Fnorkle>();
        Quark<Fnorkle> quark = new Quark<Fnorkle>();
        Particle<Long, Double> p = new Particle<Long, Double>();
        println(Arrays.toString(list.getClass().getTypeParameters()));
        println(Arrays.toString(map.getClass().getTypeParameters()));
        println(Arrays.toString(quark.getClass().getTypeParameters()));
        println(Arrays.toString(p.getClass().getTypeParameters()));
    }
}
