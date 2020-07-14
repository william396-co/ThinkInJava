package Chapter9;

import static com.thinkinjava.util.Print.*;

interface Instrument1
{
    int VALUE = 5;
    void play(Note n);
    void adjust();
}

class Wind1 implements Instrument1
{
    public String toString()
    {
        return "Wind1";
    }

    @Override
    public void play(Note n) {

        println(this+".play("+n+")");
    }


    @Override
    public void adjust() {
        println(this+".adjust()");
    }
}

class Percussion1 implements Instrument1
{
    public String toString()
    {
        return "Percussion1";
    }

    @Override
    public void play(Note n) {

        println(this+".play("+n+")");
    }

    @Override
    public void adjust() {

        println(this+".adjust()");
    }
}

class Stringed1 implements Instrument1
{
    public String toString()
    {
        return "Stringed1";
    }

    @Override
    public void play(Note n) {

        println(this+".play("+n+")");
    }

    @Override
    public void adjust() {
        println(this+".adjust()");

    }
}

class Brass1 extends Wind1
{
    public String toString()
    {
        return "Brass1";
    }
}

class WoodWin1 extends Wind1
{
    public String toString()
    {
        return "WoodWin1";
    }
}


public class Music5 {
    static void tune(Instrument1 i)
    {
        i.play(Note.B_FLAT);
    }
    static void tuneAll(Instrument1[] is)
    {
        for (Instrument1 i: is
        ) {
            i.play(Note.B_FLAT);

        }

    }

    public static void main(String[] args) {

            Instrument1[] orchestra ={
                    new Wind1(),
                    new Percussion1(),
                    new Stringed1(),
                    new Brass1(),
                    new WoodWin1()
            };
            tuneAll(orchestra);
    }
}
