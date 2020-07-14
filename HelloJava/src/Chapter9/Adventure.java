package Chapter9;

import static com.thinkinjava.util.Print.*;

interface CanFly
{
    void fly();
}

interface CanSwim
{
    void swim();
}

interface CanFight
{
    void fight();
}


class ActionCharacter
{
    public void fight(){}
}

class Hero extends ActionCharacter implements CanFight,CanSwim,CanFly
{

    @Override
    public void fly() {

    }

    @Override
    public void swim() {

    }
}



public class Adventure {

    public static void t(CanFly x){x.fly();}
    public static void u(CanFight x){x.fight();}
    public static void v(CanSwim x){x.swim();}
    public static void w(ActionCharacter x){x.fight();}

    public static void main(String[] args) {
        Hero h = new Hero();
        t(h);
        u(h);
        v(h);
        w(h);
    }
}
