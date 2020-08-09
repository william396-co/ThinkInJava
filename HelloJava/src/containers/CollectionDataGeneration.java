package containers;

import com.thinkinjava.util.CollectionData;
import com.thinkinjava.util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

import static com.thinkinjava.util.Print.*;

public class CollectionDataGeneration {

    public static void main(String[] args) {
        println(new ArrayList<String>(CollectionData.list(new RandomGenerator.String(9),10)));

        println(new HashSet<Integer>(new CollectionData<Integer>(new RandomGenerator.Integer(),10)));
    }
}
