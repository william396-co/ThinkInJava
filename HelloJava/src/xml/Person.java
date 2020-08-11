package xml;

import javax.print.Doc;
import javax.xml.*;

import nu.xom.*;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static com.thinkinjava.util.Print.*;

public class Person {

    private String first,last;
    public Person(String first,String last)
    {
        this.first = first;
        this.last = last;
    }

    public Element getXml()
    {
        Element person = new Element("person");
        Element first = new Element("first");
        first.appendChild(this.first);
        Element last = new Element("last");
        last.appendChild(this.last);
        person.appendChild(first);
        person.appendChild(last);
        return person;
    }

    public Person(Element person)
    {
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
    }

    public String toString()
    {
        return first + " " + last;
    }

    public static void format(OutputStream os, Document doc) throws Exception
    {
        Serializer serializer = new Serializer(os,"ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) throws Exception {
        List<Person> personList = Arrays.asList(
                new Person("Dr. Bunsen","Honeydew"),
                new Person("Gonzo","The Great"),
                new Person("Philip J.","Fry"));

        println(personList);

        Element root = new Element("people");
        for(Person p: personList)
            root.appendChild(p.getXml());
        Document doc = new Document(root);
        format(System.out,doc);
        format(new BufferedOutputStream(new FileOutputStream("people.xml")),doc);
    }

}
