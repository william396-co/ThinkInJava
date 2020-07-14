package Chapter7;

import static com.thinkinjava.util.Print.*;

class Instrument {
    public void play() {
        println("Instrument is palying");
    }

    static void tune(Instrument i) {
        i.play();
    }
}

public class Wind extends Instrument {
    public void play()
    {
        println("wind is palying ");
    }
    public static void main(String[] args) {
        Wind flute = new Wind();
        Instrument.tune(flute);//Upcasting
        Instrument i = new Instrument();
        Instrument.tune(i);
    }
}
