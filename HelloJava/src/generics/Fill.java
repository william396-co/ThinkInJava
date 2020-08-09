package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.thinkinjava.util.Print.*;

public class Fill {
    public static <T> void fill(Collection<T> collection,Class<? extends T> classToken,int size)
    {
        for(int i = 0; i < size; i++)
        {
            try
            {
                collection.add(classToken.newInstance());
            }catch (Exception e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}

class Contract
{
    private static long counter = 0;
    private final long id =  counter++;
    public String toString()
    {
        return getClass().getName()+" " +id;
    }
}

class TitleTransfer extends Contract
{

}

class FillTest
{
    public static void main(String[] args) {

        List<Contract> contractList  = new ArrayList<Contract>();
        Fill.fill(contractList,Contract.class,3);
        Fill.fill(contractList,TitleTransfer.class,2);

        for(Contract c: contractList)
            println(c);

    }
}
