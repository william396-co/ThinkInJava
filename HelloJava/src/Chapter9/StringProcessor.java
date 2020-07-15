package Chapter9;

import java.util.Arrays;

import static com.thinkinjava.util.Print.*;

public abstract class StringProcessor extends Processor {
    public String name()
    {
        return getClass().getSimpleName();
    }
    public abstract String process(Object input);
    public static String s = "If she weighs the same as a duck, she's made of wood";

    public static void main(String[] args) {
        Apply.process(new UpCase(),s);
        Apply.process(new Downcast(),s);
        Apply.process(new Splitter1(),s);

    }

}

class UpCase extends StringProcessor
{

    @Override
    public String process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class DownCase extends StringProcessor
{

    @Override
    public String process(Object input) {
        return ((String)input).toLowerCase();
    }
}

class Splitter1 extends StringProcessor
{
    @Override
    public String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}


