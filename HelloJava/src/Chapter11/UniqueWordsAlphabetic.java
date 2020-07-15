package Chapter11;

import com.thinkinjava.util.TextFile;

import java.util.Set;
import java.util.TreeSet;

import static com.thinkinjava.util.Print.*;


public class UniqueWordsAlphabetic {

    public static void main(String[]args)
    {
        Set<String> words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        words.addAll(  new TextFile("D:/MyProject/ThinkInJava/HelloJava/src/Chapter11/SetOperations.java","\\W+"));
        println(words);
    }
}
