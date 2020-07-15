package Chapter7;

import static com.thinkinjava.util.Print.*;

class Plate {
    Plate(int i) {
        println("Plate Constructor");
    }
}

class DinnerPlate extends Plate {

    DinnerPlate(int i) {
        super(i);
        println("DinnerPlate Constructor");
    }
}

class Utensil {
    Utensil(int i) {
        println("Utensil Constructor");
    }
}

class Spoon extends Utensil {

    Spoon(int i) {
        super(i);
        println("Spoon Constructor");
    }
}

class Fork extends Utensil {
    Fork(int i) {
        super(i);
        println("Fork Constructor");
    }
}

class Knife extends Utensil {

    Knife(int i) {
        super(i);
        println("Knife Constructor");
    }
}

class Custom {
    Custom(int i) {
        println("Custom Constructor");
    }
}


public class PlaceSetting  extends Custom{

    private Spoon sp;
    private Fork frk;
    private Knife kn;
    private DinnerPlate pl;
    public PlaceSetting(int i)
    {
        super(i + 1);
        sp = new Spoon(i+2);
        frk = new Fork(i+3);
        kn = new Knife(i+4);
        pl = new DinnerPlate(i + 5);
        println("PlaceSetting Constructor");
    }

    public static void main(String[] args) {

        PlaceSetting x = new PlaceSetting(2);
    }
}
