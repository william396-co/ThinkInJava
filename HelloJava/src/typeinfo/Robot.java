package typeinfo;

import java.util.List;
import static com.thinkinjava.util.Print.*;

public interface Robot {
    String name();
    String model();
    List<Operation> operations();

    class Test
    {

        public static void Test(Robot r)
        {
            if(r instanceof Robot)
            {
                println("Robot name: " + r.name());
                println("Robot model: " + r.model());
                for(Operation op: r.operations())
                {
                    println(op.description());
                    op.command();
                }
            }
            else
                println("[Null Robot]");
        }
    }

}
