package Chapter13.RegexMatchDemo;

import com.thinkinjava.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.thinkinjava.util.Print.*;

public class JGrep {
    public static void main(String[] args) {
        if (args.length < 2) {
            println("Usage: java JGrep file regex");
            System.exit(0);
        }

        Pattern p = Pattern.compile(args[1]);
        int index = 0;
        Matcher m = p.matcher("");
        for (String line : new TextFile(args[0])) {
            m.reset(line);
            while (m.find())
                println(index++ + ": " + m.group() + ": " + m.start());
        }
    }
}
