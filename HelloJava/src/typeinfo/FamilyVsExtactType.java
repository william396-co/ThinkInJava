package typeinfo;

import static com.thinkinjava.util.Print.*;


class Base{}
class Derived extends Base{}


public class FamilyVsExtactType {
    static void test(Object x)
    {
        println("Testing x of type " + x.getClass());
        println("x instanceOf Base " + (x instanceof Base));
        println("Derived.isInstance(x) " + Derived.class.isInstance(x));
        println("x.getClass == Base.class " + (x.getClass()==Base.class));
        println("x.getClass().equals(Base.class) " + x.getClass().equals(Base.class));
        println("x.getClass().equals(Base.class) " + x.getClass().equals(Base.class));
    }

    public static void main(String[] args) {

    }
}
