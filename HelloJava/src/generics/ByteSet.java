package generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.thinkinjava.util.Print.*;

public class ByteSet {

    Byte[] possible = {1,2,3,4,5,6,7,8,9};
    Set<Byte> mySet =
            new HashSet<Byte>(Arrays.asList(possible));


}
