package Chapter11;

import java.util.Map;

import static com.thinkinjava.util.Print.*;

public class EnvironmentVariables {

    public static void main(String[] args) {
        for(Map.Entry entry: System.getenv().entrySet())
        {
            println(entry.getKey()+":"+entry.getValue());
        }

    }
}
