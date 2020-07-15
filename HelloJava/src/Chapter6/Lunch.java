package Chapter6;

class Soup1
{
    private Soup1(){}
    public static Soup1 makeSoup()
    {
        return new Soup1();
    }
    public void f()
    {
        System.out.println("f()");
    }
}

class Soup2
{
    private Soup2(){}
    private static Soup2 sp2 = new Soup2();
    public static Soup2 access()
    {
        return sp2;
    }
    public void f()
    {
        System.out.println("f()");
    }
}


public class Lunch {

    public static void main(String[] args) {

        Soup1 sp = Soup1.makeSoup();
        sp.f();
        Soup2 sp2 = Soup2.access();
        sp2.f();
    }
}
