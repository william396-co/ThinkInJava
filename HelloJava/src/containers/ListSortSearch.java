package containers;

import java.util.*;

import static com.thinkinjava.util.Print.*;

public class ListSortSearch {
    public static void main(String[] args) {

        List<String> list =
                new ArrayList<String>(Utilities.list);

        list.addAll(Utilities.list);
        println(list);

        Collections.shuffle(list,new Random(47));
        println("Shuffled: " +list);

        ListIterator<String> it = list.listIterator(10);
        while(it.hasNext())
        {
            it.next();
            it.remove();
        }
        println("Trimmed: " + list);

        Collections.sort(list);
        println("Sorted:" +list);

        String key = list.get(7);
        int index = Collections.binarySearch(list,key);
        println("Location of "+key + " is " + index + ", list.get(" + index+") = " +list.get(index));
        Collections.sort(list,String.CASE_INSENSITIVE_ORDER);
        println("Case-Insensitive sorted:" +list);
        key = list.get(7);
        index = Collections.binarySearch(list,key,String.CASE_INSENSITIVE_ORDER);
        println("Location of "+key + " is " + index + ", list.get(" + index+") = " +list.get(index));


    }
}
