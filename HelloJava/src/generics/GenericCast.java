package generics;


import static com.thinkinjava.util.Print.*;

class FixedSizeStack<T>
{
    private int index =0;
    private Object[] storage;
    public FixedSizeStack(int size)
    {
        storage = new Object[size];
    }
    public void push(T item)
    {
        if(index < storage.length)
            storage[index++]=item;
    }
    @SuppressWarnings("unchecked")
    public T pop()
    {
        if(index>0)
            return (T)storage[--index];
        return (T)null;
    }
}


public class GenericCast {

    public static final int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack<String> stringFixedSizeStack
                = new FixedSizeStack<String>(SIZE);
        for (String s : "A B C D E F G H I J K L M".split(" "))
            stringFixedSizeStack.push(s);

        for (int i = 0; i < SIZE; i++) {
            String str = stringFixedSizeStack.pop();
            print(str + " ");
        }
        println();

    }
}
