package Chapter3;

public class TernaryIfElse {

    static int ternaryIfElse(int x)
    {
        return  x <10?x*100:x*10;
    }

    static int standardIfElse(int x)
    {
        if(x < 10)
            return  x *100;
        else
            return x *10;
    }

    public static void main(String[] args) {

        System.out.println(ternaryIfElse(9));
        System.out.println(standardIfElse(9));

        System.out.println(ternaryIfElse(56));
        System.out.println(standardIfElse(56));

    }
}
