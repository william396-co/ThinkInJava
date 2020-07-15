package Chapter11;

import java.security.cert.PolicyQualifierInfo;
import java.util.*;

import static com.thinkinjava.util.Print.*;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        Random rand = new Random(45);
        for (int i = 0; i < 10; i++)
            priorityQueue.offer(rand.nextInt(i + 10));

        QueueDemo.printQ(priorityQueue);

        List<Integer> ints = Arrays.asList(23,3,4,43,56,31,23,78,45,75);
        priorityQueue = new PriorityQueue<Integer>(ints);
        QueueDemo.printQ(priorityQueue);

        priorityQueue = new PriorityQueue<Integer>(ints.size(), Collections.<Integer>reverseOrder());
        priorityQueue.addAll(ints);
        QueueDemo.printQ(priorityQueue);


        String fact ="EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(" "));
        PriorityQueue<String> stringPQ = new PriorityQueue<String>(strings);
        QueueDemo.printQ(stringPQ);

        stringPQ = new PriorityQueue<String>(strings.size(),Collections.<String>reverseOrder());
        stringPQ.addAll(strings);
        QueueDemo.printQ(stringPQ);


        Set<Character> charSet = new HashSet<Character>();
        for(char c: fact.toCharArray())
            charSet.add(c);
        PriorityQueue<Character> characterPQ = new PriorityQueue<Character>(charSet);
        QueueDemo.printQ(characterPQ);
    }
}
