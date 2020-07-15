package Chapter11;

import typeinfo.pets.*;

import java.util.LinkedList;

import static com.thinkinjava.util.Print.*;

public class LinkedListFeatures {

    public static void main(String[] args) {

        LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(9));
        println(pets);
        println("pets.getfirst():" + pets.getFirst());
        println("pets.element():" + pets.element());
        println("pets.peek():" + pets.peek());
        println("pets.remove():" + pets.remove());
        println("pets.removefirst():" + pets.removeFirst());
        println("pets.poll():" + pets.poll());
        println(pets);

        pets.addFirst(new Rat());
        println("after addfirst():" + pets);
        pets.offer(Pets.RandomPet());
        println("after offer():" + pets);
        pets.add(Pets.RandomPet());
        println("after add():" + pets);
        pets.addLast(new Hamster());
        println("after addLast():" + pets);
        println("pets.removelast():" + pets.removeLast());
    }
}
