package Chapter14;

public class Person {
    public final String first;
    public final String last;
    public final String address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }
    public String toString()
    {
        return  "Person: " + first+" " + last+" " + address;
    }

    public static class NullPerson extends Person
    {
        private NullPerson() {
            super(null, null, null);
        }
        public String toString(){return "NullPerson";}
    }
    public static final Person NULL = new NullPerson();
}
