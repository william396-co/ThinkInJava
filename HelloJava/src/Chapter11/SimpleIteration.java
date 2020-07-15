package Chapter11;

import typeinfo.pets.*;

import java.util.Iterator;
import java.util.List;

import static com.thinkinjava.util.Print.*;

public class SimpleIteration {

    public static void main(String[] args) {

        List<Pet> pets = Pets.arrayList(12);
        Iterator<Pet> it = pets.iterator();
        while (it.hasNext()) {
            Pet p = it.next();
            print(p.id() + ":" + p + " ");
        }
        println();

        for (Pet p : pets)
            print(p.id() + ":" + p + " ");
        println();

        it = pets.iterator();
        for(int i =0; i < 6;i++)
        {
            it.next();
            it.remove();
        }
        println(pets);
    }
}
