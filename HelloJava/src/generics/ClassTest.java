package generics;

import java.math.BigDecimal;

public class ClassTest {

    public static final String Hello = "Hello";

    private String Name = "Joe";
    private BigDecimal mgBalance = BigDecimal.ZERO;

    public ClassTest()
    {

    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public static void main(String[] args) {

        ClassTest t = new ClassTest();
        System.out.println(t.getName());
    }
}
