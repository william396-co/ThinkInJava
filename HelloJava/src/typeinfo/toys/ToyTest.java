package typeinfo.toys;

import static com.thinkinjava.util.Print.*;

interface HasBatteries {
}

interface WaterProof {
}

interface Shoots {
}



public class ToyTest {

    static void printInfo(Class cc) {
        println("Class Name:" + cc.getName() +
                " is interface?[" + cc.isInterface() + "]");
        println("Simple name:" + cc.getSimpleName());
        println("Canonical name:" + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class cc = null;

        try {
            cc = Class.forName("typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            println("Can't find FancyToy");
            System.exit(1);
        }

        printInfo(cc);

        for (Class face : cc.getInterfaces())
            printInfo(face);

        Class up = cc.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            println("Cannot access");
            System.exit(1);
        }
        println(obj.getClass());
    }
}
