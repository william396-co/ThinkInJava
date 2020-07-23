package Chapter13;

import static com.thinkinjava.util.Print.*;
import typeinfo.pets.*;

import java.util.ArrayList;

public class ArrayListDisplay {

    public static void main(String[] args) {
        ArrayList<Pet> pets= new ArrayList<Pet>();
        for(Pet pet: Pets.arrayList(4))
            pets.add(pet);
        println(pets);
    }
}
