package Chapter11;

import typeinfo.pets.*;

import java.util.List;
import java.util.Random;

import static com.thinkinjava.util.Print.*;

public class ListFeatures {

    public static void main(String[] args) {
        Random rand = new Random(43);
        List<Pet> pets = Pets.arrayList(7);
        println("1:"+pets);

        Hamster h = new Hamster();
        pets.add(h);
        println("2:"+pets);


    }
}
