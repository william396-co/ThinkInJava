package Chapter13;

import com.thinkinjava.util.BinaryFile;

import java.io.File;
import java.io.IOException;

public class Hex {
    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0)
                result.append(String.format("%05X: ", n));
            result.append(String.format("%02X ", b));
            n++;
            if (n % 16 == 0)
                result.append("\n");
        }
        result.append("\n");
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0)
            System.out.println(format(BinaryFile.read("D:/MyProject/ThinkInJava/HelloJava/out/production/HelloJava/Chapter13/Hex.class")));
        else
            System.out.println(format(BinaryFile.read(new File(args[0]))));
    }
}
