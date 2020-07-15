package Chapter9;

import static com.thinkinjava.util.Print.*;

interface IProcessor
{
    String name();
    Object process(Object input);
}

class FilterAdapter implements IProcessor
{

    @Override
    public String name() {
        return null;
    }

    @Override
    public Object process(Object input) {
        return null;
    }
}

public class FilterProcessor {
}
