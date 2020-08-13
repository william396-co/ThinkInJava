package Enumerated;

import static com.thinkinjava.util.Print.*;

enum SecurityCategory {

    STOCK(Security.Stock.class),BOND(Security.Bond.class);
    Security[] values;
    SecurityCategory(Class<? extends Security>kind)
    {
        values=kind.getEnumConstants();
    }
    interface Security{
        enum Stock implements Security{SHORT,LONG,MARGIN}
        enum Bond implements Security{MUNICIPAL,JUNK}
    }
    public Security randomSelection()
    {
        return Enums.random(values);
    }

    public static void main(String[] args) {

        for(int i =0; i < 10;i++)
        {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            println(category+": " + category.randomSelection());
        }
    }
}



