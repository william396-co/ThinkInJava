package Chapter8;


import static com.thinkinjava.util.Print.*;

class Shared {
    private int refCount = 0;
    private static long counter = 0;
    private final long id = counter++;

    public Shared() {
        println("Creating " + this);
    }

    public void addRef() {
        refCount++;
    }

    protected void dispose() {
        if (--refCount == 0)
            println("Disposing " + this);
    }

    public String toString() {
        return "Shared " + id;
    }
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = 0;

    public Composing(Shared shared) {
        println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dipose() {
        println("disposing " + this);
        shared.dispose();
    }

    public String toString() {
        return "Composing " + id;
    }
}


public class ReferenceCounting {

    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composings = {
                new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared)};

        for (Composing c : composings) {
            c.dipose();
        }
    }
}
