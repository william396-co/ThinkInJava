package generics;


import static com.thinkinjava.util.Print.*;

class ClassAsFactory<T>
{
    private  T x;
    public ClassAsFactory(Class<T> kind)
    {
        try {
            x= kind.newInstance();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}

class Employee{}


public class InstantiateGenericType {

    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);

        println("ClassAsFactory<Employee> succeeded");
        try
        {
            ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
