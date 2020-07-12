package Chapter5;


enum Spiciness
{
    NOT,MILD,MEDIUM,HOT,FLAMING
}

public class SimpleEnumUse {

    public static void main(String[] args) {

        Spiciness hot = Spiciness.MEDIUM;
        System.out.println(hot);


        for (Spiciness s : Spiciness.values())
            System.out.print(s + ", ordinal " + s.ordinal());
    }
}
