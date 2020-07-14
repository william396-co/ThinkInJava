package Chapter9;

import static com.thinkinjava.util.Print.*;

enum Note {
    MIDDLE_C, C_SHARP, B_FLAT,
}

abstract class Instrument
{
    private int i;
    public abstract void play(Note n);
    public String what(){return "Instrument";}
    public abstract void adjust();
}

class Wind extends Instrument
{
    public String what(){return "Wind";}

    @Override
    public void play(Note n) {
        println("Wind.paly("+n+")");
    }

    @Override
    public void adjust() {

    }
}

class Brass extends Wind{
    public void play(Note n)
    {
        println("Brass.play("+n+")");
    }
    public String what()
    {
        return "Brass";
    }
}

class Percussion extends Instrument
{
    public String what(){return "Percussion";}

    @Override
    public void play(Note n) {
        println("Percussion.play("+n+")");
    }

    @Override
    public void adjust() {

    }
}

class Stringed extends Instrument
{
    public String what(){return "Stringed";}

    @Override
    public void play(Note n) {
        println("Stringed.play("+n+")");
    }

    @Override
    public void adjust() {

    }
}

class WoodWind extends Wind{
    public void play(Note n)
    {
        println("WoodWind.play("+n+")");
    }
    public String what()
    {
        return "WoodWind";
    }
}

public class Music4 {

    static void tune(Instrument i)
    {
        i.play(Note.B_FLAT);
    }
    static void tuneAll(Instrument[] is)
    {
        for (Instrument i: is
             ) {
            i.play(Note.B_FLAT);

        }

    }
    public static void main(String[] args) {

        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new WoodWind()};

        tuneAll(orchestra);
    }
}
