package Chapter7;

import static com.thinkinjava.util.Print.*;

class SpaceShipControls
{
    void up(int velocity){}
    void down(int velocity){}
    void left(int velocity){}
    void right(int velocity){}
    void forward(int velocity){}
    void back(int velocity){}
    void turboBoost(){}
}

class SpaceShip extends SpaceShipControls
{
    private String name;
    public SpaceShip(String name){this.name = name;}
    public String toString(){return name;}


    void up(int velocity) {
        println(name + " up " + velocity);
    }

    void down(int velocity) {
        println(name + " down " + velocity);
    }

    void left(int velocity) {
        println(name + " left " + velocity);
    }

    void right(int velocity) {
        println(name + " right " + velocity);
    }

    void forward(int velocity) {
        println(name + " forward " + velocity);
    }

    void back(int velocity) {
        println(name + " back " + velocity);
    }

    void turboBoost() {
        println(name + " turboBoost ");
    }

    /*public static void main(String[] args) {
        SpaceShip protector = new SpaceShip("NASA protector");
        protector.forward(100);
    }*/
}


public class SpaceShipDelegation {

    public static void main(String[] args) {
        SpaceShipDelegation protector = new SpaceShipDelegation("NSEA protector");
        protector.forward(100);
        protector.up(20);
        protector.down(24);
    }

    private String name;
    private SpaceShipControls controls = new SpaceShip("NASA");
    public SpaceShipDelegation(String name){this.name =name;}

    public void up(int velocity)
    {
        controls.up(velocity);
    }
    public void down(int velocity)
    {
        controls.down(velocity);
    }
    public void left(int velocity)
    {
        controls.left(velocity);
    }
    public void right(int velocity)
    {
        controls.right(velocity);
    }
    public void forward(int velocity)
    {
        controls.forward(velocity);
    }
    public void back(int velocity)
    {
        controls.back(velocity);
    }
    public void turboBoost()
    {
        controls.turboBoost();
    }
}
