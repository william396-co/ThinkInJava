package io;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import static com.thinkinjava.util.Print.*;

public class IntBufferDemo {

    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib  = bb.asIntBuffer();

        ib.put(new int[]{11,22,33,44,55,66,243,556,673,435});
        println(ib.get(3));
        ib.put(3,1883);
        ib.flip();

        while (ib.hasRemaining())
        {
            int i = ib.get();
            print(i + " ");
        }
    }
}
