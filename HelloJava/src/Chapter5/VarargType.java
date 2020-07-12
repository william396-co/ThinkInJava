package Chapter5;

public class VarargType {

    static void f(Character...args)
    {
        for (Character c : args)
            System.out.print(c + " ");
        System.out.println();
    }

    static void f(Integer...args)
    {
        for (Integer i : args)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        f('c','d','f');
        f(1,2,3,4);
    }
}
