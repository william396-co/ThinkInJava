package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

import static com.thinkinjava.util.Print.*;

public class FileLocking {

    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock fl = fos.getChannel().tryLock();
        if(fl != null)
        {
            println("Locked File");
            TimeUnit.MILLISECONDS.sleep(100);
            fl.release();
            println("Release Lock");
        }
        fos.close();
    }
}
