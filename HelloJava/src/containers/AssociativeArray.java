package containers;

import com.thinkinjava.util.RandomGenerator;

import static com.thinkinjava.util.Print.*;

public class AssociativeArray<K,V> {

    private Object[][] pairs;
    private int index;
    public AssociativeArray(int len)
    {
        pairs = new Object[len][2];
    }

    public void put(K key, V value)
    {
        if(index>=pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++]=new Object[]{key,value};
    }

    public V get(K key) {
        for (int i = 0; i < index; i++)
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        return null;
    }
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < index;i++)
        {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if(i< index-1)
                result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String,String> map =
                new AssociativeArray<String, String>(6);
        map.put("sky","blue");
        map.put("grass","green");
        map.put("ocean","dancing");
        map.put("earth","brown");
        map.put("sun","warm");
        map.put("tree","tall");

        try
        {
            map.put("extra","objec");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            println("Too many objects");
        }
        println(map);
        println(map.get("ocean"));
    }

}
