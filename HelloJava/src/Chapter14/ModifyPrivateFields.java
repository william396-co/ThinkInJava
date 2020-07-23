package Chapter14;

import java.lang.reflect.Field;

import static com.thinkinjava.util.Print.*;

class WithPrivateFinalField {
    private int i = 1;
    private final String s = "I'm totally safe";
    private String s2 = "Am I Safe";

    public String toString() {
        return "i= " + i + ", " + s + ", " + s2;
    }
}

public class ModifyPrivateFields {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        println(pf);

        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        println("f.getInt(pf):" + f.getInt(pf));
        f.setInt(pf,47);
        println(pf);


        f = pf.getClass().getDeclaredField("s");
        f.setAccessible(true);
        println("f.get(pf): "+f.get(pf));
        f.set(pf,"No,you're not!");
        println(pf);

        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        println("f.get(pf): "+f.get(pf));
        f.set(pf,"No,you're not!");
        println(pf);

    }
}
