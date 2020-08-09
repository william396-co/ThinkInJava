package generics;


import java.util.ArrayList;
import java.util.List;

import static com.thinkinjava.util.Print.*;

public class GenericsAndConvariance {

    public static void main(String[] args) {
        List<? extends Fruit> flist = new ArrayList<Fruit>();

        flist.add(null);
        //flist.add(new Apple())
        Fruit f = flist.get(0);
        print(f);
    }
}
