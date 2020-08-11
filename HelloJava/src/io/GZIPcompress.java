package io;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import static com.thinkinjava.util.Print.*;


public class GZIPcompress {

    public static void main(String[] args) throws IOException {

        if(args.length==0)
        {
            println(
                    "Usage:\nGZIPcompress file\n"+
                    "\tUses GZIP compression to compress " +
                    "the file to test.gz");
            System.exit(1);
        }

        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(
                new FileOutputStream("test.gz")));

        println("Writing file");
        int c;
        while ((c = in.read()) != -1)
            out.write(c);
        in.close();
        out.close();

        println("Reading file");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(
                new FileInputStream("test.gz"))));
        String s;
        while ((s=in2.readLine())!=null)
            println(s);


    }
}
