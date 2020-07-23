package Chapter14;

import java.util.HashMap;
import java.util.Map;


public class TypeCounter extends HashMap<Class<?>,Integer> {

    private Class<?> baseType;
    public TypeCounter(Class<?> baseType)
    {
        this.baseType = baseType;
    }
    public void count(Object obj)
    {
        Class<?> type = obj.getClass();
        if(!baseType.isAssignableFrom(type))
            throw new RuntimeException(obj+" incorrect type :"+ type+",should be type or subtype of"+baseType);
        coutClass(type);
    }
    private void coutClass(Class<?> type)
    {
        Integer quantity = get(type);
        put(type,quantity==null?1:quantity+1);
        Class<?> superClass = type.getSuperclass();
        if(superClass!=null && baseType.isAssignableFrom(superClass))
            coutClass(superClass);
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder("{");
        for(Map.Entry<Class<?>,Integer> pair: entrySet())
        {
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(", ");
        }
        result.delete(result.length()-2,result.length());
        result.append("}");
        return result.toString();
    }

}
