package containers;

import com.thinkinjava.util.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import static com.thinkinjava.util.Print.*;

public class QueueBehavior {

    private static int count = 10;

    static <T> void test(Queue<T> queue, Generator<T> gen) {
        for (int i = 0; i < count; i++)
            queue.offer(gen.next());

        while (queue.peek() != null)
            print(queue.remove() + " ");
        println();
    }

    static class Gen implements Generator<String> {
        String[] s = ("one two three four five six seven eight nigh ten").split(" ");
        int i;

        public String next() {
            return s[i++];
        }
    }

    public static void main(String[] args) {
        test(new LinkedList<String>(),new Gen());
        test(new PriorityQueue<String>(),new Gen());
    }
}
