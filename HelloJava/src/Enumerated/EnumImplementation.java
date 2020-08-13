package Enumerated;


import com.thinkinjava.util.Generator;

import java.util.Random;

import static com.thinkinjava.util.Print.*;

enum CartoonCharacter implements Generator<CartoonCharacter>
{
    SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;

    private Random random = new Random();
    public CartoonCharacter next()
    {
        return values()[random.nextInt(values().length)];
    }
}

public class EnumImplementation {

    public static <T> void printNext(Generator<T> arg)
    {
        print(arg.next()+", ");
    }

    public static void main(String[] args) {
        CartoonCharacter cc  = CartoonCharacter.BOB;
        for(int i =0; i < 10;i++)
            printNext(cc);
    }
}
