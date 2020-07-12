package Chapter5;

public class OptionalTrailingArguments {

    static void f(int required, String... trailings) {
        System.out.print("required: " + required + " ");
        for (String s : trailings)
            System.out.print(s + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        f(1,"one");
        f(2,"one","two");
        f(3,"one","two","three");
    }
}
