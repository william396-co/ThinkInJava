package Chapter11;

import typeinfo.pets.*;

import java.util.*;

import static com.thinkinjava.util.Print.*;

public class CrossContainerIteration {
    public static void display(Iterator<Pet> it)
    {
        while(it.hasNext())
        {
            Pet p= it.next();
            print(p.id()+":"+p+" ");
        }
        println();
    }

    public static void main(String[] args) {
        ArrayList<Pet> pets = Pets.arrayList(8);
        LinkedList<Pet> petsLL = new LinkedList<Pet>(pets);
        HashSet<Pet> petsHS = new HashSet<Pet>(pets);
        TreeSet<Pet> petsTS = new TreeSet<Pet>(pets);

        display(pets.iterator());
        display(petsLL.iterator());
        display(petsHS.iterator());
        display(petsTS.iterator());
    }
}
