package Chapter14;


import static com.thinkinjava.util.Print.*;
import typeinfo.toys.*;

public class GenericToyTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<FancyToy> ftClass = FancyToy.class;

        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        Object obj = up.newInstance();

    }
}
