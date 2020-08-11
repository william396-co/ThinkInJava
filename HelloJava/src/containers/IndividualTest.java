package containers;

import Chapter11.MapOfList;
import typeinfo.pets.*;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static com.thinkinjava.util.Print.*;

public class IndividualTest {

    public static void main(String[] args) {
        Set<Individual> pets = new TreeSet<Individual>();
        for(List<? extends Pet> lp: MapOfList.petPeople.values())
        {
            for(Pet p: lp)
                pets.add(p);
        }
        println(pets);
    }
}
