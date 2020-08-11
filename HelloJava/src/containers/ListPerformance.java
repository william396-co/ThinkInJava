package containers;


import com.thinkinjava.util.CountingGenerator;
import com.thinkinjava.util.CountingIntegerList;
import com.thinkinjava.util.Generated;
import com.thinkinjava.util.Generator;

import java.awt.*;
import java.util.*;
import java.util.List;

import static com.thinkinjava.util.Print.*;

public class ListPerformance {

    static Random random = new Random();
    static int reps = 1000;
    static List<Test<List<Integer>>> tests
            = new ArrayList<Test<List<Integer>>>();
    static List<Test<LinkedList<Integer>>> qTests =
            new ArrayList<Test<LinkedList<Integer>>>();

    static
    {
        tests.add(new Test<List<Integer>>("add") {
            @Override
            int test(List<Integer> container, TestParam tp) {

                int loops = tp.loops;
                int listsize = tp.size;
                for(int i =0; i < loops;i++)
                {
                    container.clear();
                    for(int j=0; j < listsize;j++)
                        container.add(j);
                }
                return listsize * loops;
            }
        });

        tests.add(new Test<List<Integer>>("get") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops =tp.loops* reps;
                int listsize = container.size();
                for(int i =0;i < loops;i++)
                    container.get(random.nextInt(listsize));
                return loops;
            }
        });


        tests.add(new Test<List<Integer>>("set") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops = tp.loops * reps;
                int listsize= container.size();
                for(int i =0; i < loops;i++)
                    container.set(random.nextInt(listsize),47);
                return loops;
            }
        });

        tests.add(new Test<List<Integer>>("iteradd")
        {
            int test(List<Integer> container, TestParam tp) {

                final int LOOPS = 1000000;
                int half = container.size()/2;
                ListIterator<Integer> it = container.listIterator(half);
                for(int i =0; i < LOOPS;i++)
                    it.add(47);
                return LOOPS;
            }
        });

        tests.add(new Test<List<Integer>>("insert")
        {
            int test(List<Integer> list,TestParam tp)
            {
                int loops = tp.loops;
                for(int i =0; i < loops;i++)
                    list.add(47);
                return loops;
            }
        });


        tests.add(new Test<List<Integer>>("remove"){
            int test(List<Integer> list,TestParam tp)
            {
                int loops = tp.loops;
                int size = tp.size;
                for(int i = 0; i < loops;i++)
                {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while(list.size()>5)
                        list.remove(5);
                }
                return loops*size;
            }
        });


        qTests.add(new Test<LinkedList<Integer>>("addFirst")
        {
            int test(LinkedList<Integer> list,TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < size; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addFirst(47);
                }
                return loops * size;
            }
        });

        qTests.add(new Test<LinkedList<Integer>>("addLast")
        {
            int test(LinkedList<Integer> list, TestParam tp)
            {
                int loops = tp.loops;
                int size = tp.size;
                for(int i= 0; i < loops;i++)
                {
                    list.clear();
                    for(int j =0;j <size;j++)
                        list.addLast(46);
                }
                return loops *size;
            }
        });

        qTests.add(new Test<LinkedList<Integer>>("rmFirst")
        {
            int test(LinkedList<Integer>list, TestParam tp)
            {
                int loops = tp.loops;
                int size=  tp.size;
                for(int i = 0; i < loops;i++)
                {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while(list.size()>0)
                        list.removeFirst();
                }
                return loops *size;
            }

        });

        qTests.add(new Test<LinkedList<Integer>>("rmLast") {
            @Override
            int test(LinkedList<Integer> list, TestParam tp) {

                int loops = tp.loops;
                int size=  tp.size;
                for(int i = 0;i < loops;i++)
                {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while(list.size()>0)
                        list.removeLast();
                }
                return loops*size;
            }
        });
    }

    static class ListTester extends Tester<List<Integer>>
    {

        public ListTester(List<Integer> container, List<Test<List<Integer>>> tests) {
            super(container, tests);
        }

        protected List<Integer> initialize(int size)
        {
            container.clear();
            container.addAll(new CountingIntegerList(size));
            return container;
        }
        public static void run(List<Integer> list,List<Test<List<Integer>>> tests)
        {
            new ListTester(list,tests).timedTest();
        }
    }

    public static void main(String[] args) {
        if(args.length > 0)
            Tester.defaultParams = TestParam.array(args);

        Tester<List<Integer>> arrayTest
                =new Tester<List<Integer>>(null,tests.subList(1,3))
        {
            @Override protected
            List<Integer> initialize(int size)
            {
                Integer[] ia = Generated.array(Integer.class,new CountingGenerator.Integer(),size);
                return Arrays.asList(ia);
            }
        };

        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();
        Tester.defaultParams = TestParam.array(10,5000,100,5000,1000,5000,10000,200);

        if(args.length>0)
            Tester.defaultParams= TestParam.array(args);
        ListTester.run(new ArrayList<Integer>(),tests);
        ListTester.run(new LinkedList<Integer>(),tests);
        ListTester.run(new Vector<Integer>(),tests);
        Tester.fieldwidth = 12;
        Tester<LinkedList<Integer>> qTest
                = new Tester<LinkedList<Integer>>(new LinkedList<Integer>(),qTests);
        qTest.setHeadline("Queue test");
        qTest.timedTest();
    }

}
