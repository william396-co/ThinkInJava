package Enumerated;

import java.text.DateFormat;
import java.util.Date;

import static com.thinkinjava.util.Print.*;

public enum  ConstantSpecificMethod {

    DATE_TIME{String getInfo(){
        return DateFormat.getDateInstance().format(new Date());
    }},
    CLASSPTH{String getInfo(){
        return System.getenv("CLASSPATH");
    }},
    VERSION{String getInfo(){
        return System.getProperty("java.version");
    }};

    abstract String getInfo();

    public static void main(String[] args) {


        for(ConstantSpecificMethod csm: values())
            println(csm.getInfo());
    }

}
