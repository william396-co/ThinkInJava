package Chapter11;

import java.util.Set;
import java.util.TreeSet;


import static com.thinkinjava.util.Print.*;
import com.thinkinjava.util.TextFile;

public class UniqueWords {

    public static void main(String[] args)
    {
        Set<String> words = new TreeSet<String>(
                new TextFile("D:/MyProject/ThinkInJava/HelloJava/src/Chapter11/SetOperations.java","\\W+"));
        println(words);
    }
}
