package io;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import static com.thinkinjava.util.Print.*;

public class PreferencesDemo {
    public static void main(String[] args) throws BackingStoreException {

        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
        prefs.put("Location","Oz");
        prefs.put("FootWear","Ruby Slippers");
        prefs.putInt("Companions",4);
        prefs.putBoolean("Are there witches?",true);
        int usageCount = prefs.getInt("UsageCount",0);
        usageCount++;
        prefs.putInt("UsageCount",usageCount);
        for(String key:prefs.keys())
            println(key+": " + prefs.get(key,null));
        println("How many Companions does Dorothy hava? " + prefs.getInt("Companions",0));

    }
}
