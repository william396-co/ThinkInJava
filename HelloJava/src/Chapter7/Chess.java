package Chapter7;

import static com.thinkinjava.util.Print.*;


class Game
{
    Game(int i)
    {
        println("Game Constructor");
    }
}

class BoardGame extends Game
{

    BoardGame(int i) {
        super(i);
        println("BoardGame Constructor");
    }
}

public class Chess  extends BoardGame{

    Chess() {
        super(11);
        println("Chess Constructor");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
}
