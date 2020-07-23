package Chapter14;

import static com.thinkinjava.util.Print.*;

public class GenericClassReferences {

    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;

        genericIntClass = Integer.class;
        //genericIntClass = Double.class;
    }
}
