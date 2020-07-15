package Chapter7;

import static com.thinkinjava.util.Print.*;

class Engine {
    public void start() {
        println("Engine start");
    }

    public void rev() {
        println("Engine rev");
    }

    public void stop() {
        println("Engine stop");
    }
}

class Wheel {
    public void inflat(int psi) {
        println("Wheel inflat" + psi);
    }
}

class Window {
    public void rollup() {

        println("Window rollup");
    }

    public void rolldown() {

        println("Window rolldown");
    }
}

class Door {
    public Window window = new Window();

    public void open() {
        println("Door open");
    }

    public void close() {
        println("Door close");
    }
}


public class Car {
    public Engine engine = new Engine();
    public Wheel[] wheels = new Wheel[4];
    public Door leftDoor = new Door(),
            rightDoor = new Door();

    public Car() {
        for (int i = 0; i < wheels.length; i++)
            wheels[i] = new Wheel();
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.leftDoor.window.rollup();
        car.leftDoor.open();
        car.rightDoor.close();
        car.wheels[0].inflat(10);
    }
}
