package Enumerated;

import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import static com.thinkinjava.util.Print.*;


enum Explore {HERE, THERE}

public class Reflection {

    public static Set<String> analyze(Class<?>enumClass){
        println("---------Analyzing " + enumClass + "--------------");
        println("Interfaces:");
        for(Type t: enumClass.getGenericInterfaces())
            print(t);
        println("Base: " + enumClass.getSuperclass() );
        println("Methods: ");
        Set<String> methods = new TreeSet<String>();
        for(Method m: enumClass.getMethods())
            methods.add(m.getName());
        println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        println("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods) );
        print("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        println(exploreMethods);
    }
}
