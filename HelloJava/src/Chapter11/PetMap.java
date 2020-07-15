package Chapter11;


import static com.thinkinjava.util.Print.*;
import typeinfo.pets.*;

import java.util.Map;
import java.util.HashMap;

public class PetMap {

    public static void main(String[]args)
    {
        Map<String,Pet> petMap = new HashMap<String,Pet>();
        petMap.put("My Cat",new Cat());
        petMap.put("My Dog",new Dog());
        petMap.put("My Hamster",new Hamster());
        println(petMap);

        Pet dog= petMap.get("My Dog");
        println(dog);

        println(petMap.containsKey("My Dog"));
        println(petMap.containsValue(dog));

    }
}
