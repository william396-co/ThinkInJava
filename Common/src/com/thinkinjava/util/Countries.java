package com.thinkinjava.util;

import java.util.*;

import static com.thinkinjava.util.Print.*;

public class Countries {

    public static final String[][] DATA =
            {
                    //Africa
                    {"ALGENRIA", "Algeris"}, {"ANGOLA", "Lunada"},
                    {"BENIN", "Port-Novo"}, {"BOTSWANA", "Gaberone"},
                    {"BURKINA FASO","Ouagadougou"},
                    {"BURUNDI","Bujumbura"},
                    {"CAMEROON","Yaounde"},{"CAPE VERDE","Praia"},
                    {"CENTRAL AFRICAN REPUBLIC","Bangui"},
                    {"CHAD","N'djamena"}, {"COMOROS", "Moroni"},
                    {"CONGO","Brazzaville"},{"DJIBOUTI","Dijibouti"},
                    {"EGYPT","Cairo"},{"EQUATORIAL GUINEA","Malabo"},

            };
    private static class FlyWeightMap extends AbstractMap<String,String>
    {
        private static class Entry implements Map.Entry<String,String>
        {
            int index;
            Entry(int index){this.index = index;}
            public boolean eqauls(Object o)
            {
                return DATA[index][0].equals(o);
            }
            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return DATA[index][1];
            }

            @Override
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }
        }

        static class EntrySet extends AbstractSet<Map.Entry<String, String>>
        {
            private int size;
            EntrySet(int size)
            {
                if(size < 0)
                    this.size = 0;
                else if(size > DATA.length)
                    this.size = DATA.length;
                else
                    this.size = size;
            }

            private class Iter implements Iterator<Map.Entry<String,String>>
            {
                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < size-1;
                }

                @Override
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }

                @Override
                public void remove() {
                    throw  new UnsupportedOperationException();
                }
            }
            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                return new Iter();
            }

            @Override
            public int size() {
                return size;
            }
        }

        private static Set<Map.Entry<String,String>> entries = new EntrySet(DATA.length);
        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return entries;
        }
    }

    static Map<String,String> select(final int size)
    {
        return new FlyWeightMap()
        {
            public Set<Map.Entry<String,String>> entrySet()
            {
                return new EntrySet(size);
            }
        };
    }

    static Map<String,String> map = new FlyWeightMap();
    public static Map<String,String> capitals()
    {
        return map;
    }

    public static Map<String,String> capitals(int size)
    {
        return select(size);
    }
    static List<String> names =
            new ArrayList<String>(map.keySet());
    public static List<String> names(){return names;}
    public static List<String> names(int size)
    {
        return new ArrayList<String>(select(size).keySet());
    }

    public static void main(String[] args) {
        println(capitals(10));
        println(names(10));
        println(new HashMap<String, String>(capitals(3)));
        println(new LinkedHashMap<String, String>(capitals(3)));
        println(new TreeMap<String, String>(capitals(3)));
        println(new Hashtable<String, String>(capitals(3)));
        println(new HashSet<String>(names(6)));
        println(new LinkedHashSet<String>(names(6)));
        println(new TreeSet<String>(names(6)));
        println(new ArrayList<String>(names(6)));
        println(new LinkedList<String>(names(6)));
        println(capitals().get("BURUNDI"));
    }
}
