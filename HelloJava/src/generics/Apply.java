package generics;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.thinkinjava.util.Print.*;

public class Apply
{
    public static <T,S extends Iterable<? extends T>>
    void play(S seq, Method f, Object...args)
    {
        try
        {
            for(T t: seq)
                f.invoke(t,args);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}

class Shape{
    public void rotate(){println(this+" rotate");}
    public void resize(int newSize)
    {
        println(this+" resize " + newSize);
    }
}

class Square extends Shape{}


class FilledList<T> extends ArrayList<T>
{
    public FilledList(Class<? extends T> type,int size)
    {
        try
        {
            for(int i = 0;i < size;i++)
                add(type.newInstance());
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

}

class ApplyTest {

    public static void main(String[] args) throws NoSuchMethodException {
        List<Shape> shapeList = new ArrayList<Shape>();
        for(int i =0; i < 10;i++)
            shapeList.add(new Shape());

        Apply.play(shapeList,Shape.class.getMethod("rotate"));

        println("=============================================");

        SimpleQueue simpleQueue = new SimpleQueue<Shape>();
        for (int i =0; i < 5;i++)
        {
            simpleQueue.add(new Shape());
            simpleQueue.add(new Shape());
        }
        Apply.play(simpleQueue,Shape.class.getMethod("rotate"));
    }
}
