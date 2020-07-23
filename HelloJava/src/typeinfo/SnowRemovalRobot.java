package typeinfo;


import java.util.Arrays;
import java.util.List;

import static com.thinkinjava.util.Print.*;

public class SnowRemovalRobot implements Robot {

    private String name;
    public SnowRemovalRobot(String name){this.name = name;}
    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "SnowBot Series 11";
    }

    @Override
    public List<Operation> operations() {
        return null;
       /* return new Arrays.asList(
                new Operation() {
                    public String description() {
                        return name + " can shovel snow";
                    }

                    public void command() {
                        println(name + " shoveling snow");
                    }
                },
                new Operation() {

                    public String description() {
                        return name + " can chip ice";
                    }

                    public void command() {
                        println(name + " chipping ice");
                    }
                },
                new Operation() {
                    public String description() {
                        return name + " can clean the roof";
                    }

                    public void command() {
                        println(name + " clearing roof");
                    }
                }
                );*/
    }

    public static void main(String[] args) {
        Robot.Test.Test(new SnowRemovalRobot("Slusher"));
    }
}
