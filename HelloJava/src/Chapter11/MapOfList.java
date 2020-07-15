package Chapter11;


import static com.thinkinjava.util.Print.*;

import Chapter7.CADSystem;
import typeinfo.pets.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapOfList {

    public static Map<Person, List<? extends Pet>> petPeople
            = new HashMap<Person, List<? extends Pet>>();

    static {
        petPeople.put(new Person("Dawn"),
                Arrays.asList(new Cymric("Molly"), new Mutt("Spot")));
        petPeople.put(new Person("Kate"),
                Arrays.asList(new Cat("Shackleton"), new Cat("Elsie May"), new Dog("Margret")));
        petPeople.put(new Person("Marilyn"),
                Arrays.asList(new Pug("Louie aka Louis snorklestein Dupree"),
                        new Cat("Stanford aka Stinky el Nergro"),
                        new Cat("Pinkola")));
        petPeople.put(new Person("Luke"),
                Arrays.asList(new Rat("Fuzzy"), new Rat("Fizzy")));
        petPeople.put(new Person("Issac"),
                Arrays.asList(new Rat("Freckly")));
    }

    public static void main(String[] args) {

        println("People:" + petPeople.keySet());
        println("pets:" + petPeople.values());
        for (Person person : petPeople.keySet()) {
            print(person + " has:");
            for (Pet pet : petPeople.get(person))
                print(" " + pet);
            println();
        }
    }
}
