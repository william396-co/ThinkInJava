package Enumerated;

import static com.thinkinjava.util.Print.*;

public enum OzWitch {

    WEST("Miss Gulch aka the Wicked Witch of the west"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East,wearer of the Ruby " +
            "Slippers, curshed by Dorothy's house"),
    SOUTH("Good by inference,but missing");

    private String description;

    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {

        for (OzWitch witch : OzWitch.values())
            println(witch + ": " + witch.getDescription());
    }
}
