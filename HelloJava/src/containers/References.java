package containers;

import static com.thinkinjava.util.Print.*;

class VeryBig
{
    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;
    public VeryBig(String id){ident =id;}
    public String toString(){return ident;}
    protected void finalize()
    {
        println("Finalizing " +ident);
    }
}

public class References {
}
