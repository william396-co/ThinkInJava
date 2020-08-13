package Enumerated;

import java.util.Iterator;
import java.util.Random;

import static com.thinkinjava.util.Print.*;


interface Item
{
    Outcome complete(Item it);
    Outcome eval(Paper p);
    Outcome eval(Scissor s);
    Outcome eval(Rock r);
}

class Paper implements Item{

    @Override
    public Outcome complete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return Outcome.DRAW;
    }

    @Override
    public Outcome eval(Scissor s) {
        return Outcome.WIN;
    }

    @Override
    public Outcome eval(Rock r) {
        return Outcome.LOSE;
    }

    @Override
    public String toString() {
        return "Paper";
    }
}

class Scissor implements Item{

    @Override
    public Outcome complete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return Outcome.LOSE;
    }

    @Override
    public Outcome eval(Scissor s) {
        return Outcome.DRAW;
    }

    @Override
    public Outcome eval(Rock r) {
        return Outcome.WIN;
    }

    @Override
    public String toString() {
        return "Scissor";
    }
}

class Rock implements Item{

    @Override
    public Outcome complete(Item it) {
        return it.eval(this);
    }

    @Override
    public Outcome eval(Paper p) {
        return Outcome.LOSE;
    }

    @Override
    public Outcome eval(Scissor s) {
        return Outcome.DRAW;
    }

    @Override
    public Outcome eval(Rock r) {
        return Outcome.WIN;
    }
}

public class RoShamBo1 {
    static final int SIZE = 20;
    private static Random random = new Random();
    public static Item newItem()
    {
        switch (random.nextInt(3)){
            default:
            case 0: return new Scissor();
            case 1: return new Paper();
            case 2: return new Rock();
        }
    }

    public static void match(Item a,Item b)
    {
        println(a.toString() + " vs. " +b.toString() +" : " + a.complete(b));
    }

    public static void main(String[] args) {
        for(int i =0; i < SIZE;i++)
            match(newItem(),newItem());
    }

}
