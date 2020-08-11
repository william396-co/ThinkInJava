package containers;

import com.thinkinjava.util.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

import static com.thinkinjava.util.Print.*;

public class Enumerations {
    public static void main(String[] args) {
        Vector<String> vector
                = new Vector<String>(Countries.names(10));
        Enumeration<String> e = vector.elements();
        while (e.hasMoreElements())
            print(e.nextElement() + ", ");
        e = Collections.enumeration(new ArrayList<String>());
    }
}
