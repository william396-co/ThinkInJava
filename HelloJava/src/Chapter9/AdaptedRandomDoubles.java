package Chapter9;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class AdaptedRandomDoubles extends RandomDoubles implements Readable {

    private int Count;

    public AdaptedRandomDoubles(int count) {
        Count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (Count == 0)
            return -1;
        String result = Double.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new AdaptedRandomDoubles(7));
        while (s.hasNextDouble())
            System.out.print(s.nextDouble() + " ");
    }
}
