package Chapter8;

import static com.thinkinjava.util.Print.*;

enum Note {
    MIDDLE_C, C_SHARP, B_FLAT,
}


class Instrument {
    public void Play(Note n) {
        println("Instrument.paly(" + n + ")");
    }

    public String What() {
        return "Instrument";
    }

    public void adjust() {
        println("Adjusting Instrument");
    }
}

class Wind extends Instrument {
    public void Play(Note n) {
        println("Wind.play(" + n + ")");
    }

    public String What() {
        return "Wind";
    }

    public void adjust() {
        println("Adjusting Wind");
    }
}

class Percussion extends Instrument {
    public void Play(Note n) {
        println("Percussion.play(" + n + ")");
    }

    public String What() {
        return "Percussion";
    }

    public void adjust() {
        println("Adjusting Percussion");
    }
}

class Stringed extends Instrument {
    public void Play(Note n) {
        println("Stringed.play(" + n + ")");
    }

    public String What() {
        return "Stringed";
    }

    public void adjust() {
        println("Adjusting Stringed");
    }
}

class Brass extends Instrument {
    public void Play(Note n) {
        println("Brass.play(" + n + ")");
    }

    public String What() {
        return "Brass";
    }

    public void adjust() {
        println("Adjusting Brass");
    }
}

class WoodWind extends Wind {
    public void Play(Note n) {
        println("WoodWind.play(" + n + ")");
    }

    public String What() {
        return "WoodWind";
    }
}

public class Music {

    public static void tune(Instrument i, Note n) {
        i.Play(n);
    }

    public static void tuneAll(Instrument[] e, Note n) {
        for (Instrument i : e) {
            i.Play(n);
            i.adjust();
        }
    }

    public static void main(String[] args) {

        Instrument[] orchestra = {new Wind(), new Percussion(), new Stringed(), new Brass(), new WoodWind()};
        tuneAll(orchestra, Note.B_FLAT);


        println("=============================");
        Wind flute = new Wind();
        tune(flute, Note.MIDDLE_C);

        Instrument i = new Instrument();
        tune(i, Note.B_FLAT);

        Brass b = new Brass();
        tune(b, Note.C_SHARP);

        Stringed s = new Stringed();
        tune(s, Note.B_FLAT);
    }

}
