package io;

import java.nio.*;

import static com.thinkinjava.util.Print.*;

public class ViewBuffers {

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});
        bb.rewind();
        print("Byte Buffer ");

        while (bb.hasRemaining())
            print(bb.position() + "->" + bb.get() + ", ");
        println();

        CharBuffer cb = ((ByteBuffer) bb.rewind()).asCharBuffer();
        print("Char Buffer ");
        while (cb.hasRemaining())
            print(cb.position() + "->" + cb.get() + ", ");
        println();

        FloatBuffer fb = ((ByteBuffer) bb.rewind()).asFloatBuffer();
        print("Float Buffer ");
        while (fb.hasRemaining())
            print(fb.position() + "->" + fb.get() + ", ");
        println();

        IntBuffer ib = ((ByteBuffer) bb.rewind()).asIntBuffer();
        print("Int Buffer ");
        while (ib.hasRemaining())
            print(ib.position() + "->" + ib.get() + ", ");
        println();

        LongBuffer lb = ((ByteBuffer) bb.rewind()).asLongBuffer();
        print("Long Buffer ");
        while (lb.hasRemaining())
            print(lb.position() + "->" + lb.get() + ", ");
        println();

        ShortBuffer sb = ((ByteBuffer) bb.rewind()).asShortBuffer();
        print("Short Buffer ");
        while (sb.hasRemaining())
            print(sb.position() + "->" + sb.get() + ", ");
        println();

        DoubleBuffer db = ((ByteBuffer) bb.rewind()).asDoubleBuffer();
        print("Double Buffer ");
        while (db.hasRemaining())
            print(db.position() + "->" + db.get() + ", ");
        println();
    }
}
