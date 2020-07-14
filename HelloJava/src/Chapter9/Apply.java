package Chapter9;

import java.util.Arrays;

import static com.thinkinjava.util.Print.*;

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}

class Upcast extends Processor {
    String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcast extends Processor {
    String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor {
    String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}


public class Apply {

    public static void process(Processor p, Object s) {
        println("Using Processor " + p.name());
        println(p.process(s));
    }

    public static String s = "Disagreement with beliefs is by definition incorrect";

    public static void main(String[] args) {
        process(new Upcast(), s);
        process(new Downcast(), s);
        process(new Splitter(), s);
    }

}
