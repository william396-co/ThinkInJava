package Chapter7;

import com.sun.org.apache.xpath.internal.operations.Or;

import static com.thinkinjava.util.Print.*;

class Villain {
    private String name;

    protected void setName(String name) {
        this.name = name;
    }

    public Villain(String name) {
        this.name = name;
    }

    public String toString() {
        return "I'm Villain and my name is " + name;
    }
}

public class Orc extends Villain {

    private int orcNumber;

    public Orc(String name, int orcNumber) {
        super(name);
        this.orcNumber = orcNumber;
    }

    public void Change(String name, int orcNumber) {
        setName(name);
        this.orcNumber = orcNumber;
    }

    public String toString() {
        return "Orc " + orcNumber + ": " + super.toString();
    }

    public static void main(String[] args) {
        Orc orc = new Orc("Limburger", 12);
        println(orc);
        orc.Change("Bob", 9);
        println(orc);
    }
}
