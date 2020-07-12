package Chapter5;


class A
{

}

public class VarArgs {

    static void printArray(Object[] args) {
        for (Object obj : args)
            System.out.print(obj + " ");
        System.out.println();
    }

    static void printArrayEx(Object... args) {
        for (Object obj : args)
            System.out.print(obj + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(new Object[]{new Integer(45),new Float(3.14),
                new Double(11.1),new String("Hello")});

        printArray(new Object[]{"one","two","three"});
        printArray(new Object[]{new A(),new A(),new A()});


        printArrayEx(45,434.5,"Hello");

    }
}
