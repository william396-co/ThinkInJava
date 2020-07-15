package Chapter11;

import typeinfo.pets.*;

import java.util.List;
import java.util.ListIterator;

import static com.thinkinjava.util.Print.*;

public class ListIteration {

    public static void main(String[] args) {

        List<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext())
            print(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
        println();


        while (it.hasPrevious())
            print(it.previous().id() + " ");
        println();

        println(pets);

        it = pets.listIterator(3);
        while (it.hasNext()) {
            it.next();
            it.set(Pets.RandomPet());
        }
        println(pets);

    }

}
