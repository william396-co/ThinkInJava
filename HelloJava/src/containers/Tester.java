package containers;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.thinkinjava.util.Print.*;

public class Tester<C> {
    public static int fieldwidth = 8;
    public static TestParam[] defaultParams = TestParam.array(10,5000,100,5000,1000,5000,10000,500);
    protected C initialize(int size){return container;}
    protected C container;
    private String headline ="";
    private List<Test<C>> tests;
    private Set<Test<C>> testSets;
    private static String stringField() {
        return "%" + fieldwidth + "s";
    }

    private static String numberField() {
        return "%" + fieldwidth + "d";
    }

    private static int sizeWidth = 5;
    private static String sizeField = "%" + sizeWidth+"s";
    private TestParam[] paramsList = defaultParams;


    public Tester(C container,Set<Test<C>> testSets)
    {
        this.container = container;
        this.testSets = testSets;
        if(container !=null)
            headline = container.getClass().getSimpleName();
    }
    public Tester(C container,List<Test<C>>tests)
    {
        this.container = container;
        this.tests = tests;
        if(container!=null)
            headline = container.getClass().getSimpleName();
    }
    public Tester(C container,List<Test<C>>tests,TestParam[] paramsList)
    {
        this(container,tests);
        this.paramsList = paramsList;
    }
    public Tester(C container,Set<Test<C>> testSets,TestParam[]paramsList)
    {
        this(container,testSets);
        this.paramsList = paramsList;
    }


    public void setHeadline(String newHeadline)
    {
        headline = newHeadline;
    }


    public static <C> void run(C cntnr,List<Test<C>>tests)
    {
        new Tester<C>(cntnr,tests).timedTest();
    }
    public static <C> void run(C cntnr,Set<Test<C>>tests)
    {
        new Tester<C>(cntnr,tests).timedTest();
    }

    public static <C> void run(C cntnr,List<Test<C>> tests,TestParam[]paramsList)
    {
        new Tester<C>(cntnr,tests,paramsList).timedTest();
    }
    public static <C> void run(C cntr, Set<Test<C>> tests, TestParam[]paramsList)
    {
        new Tester<C>(cntr,tests,paramsList).timedTest();
    }

    private void displayHeader()
    {
        int width = fieldwidth* tests.size()+sizeWidth;
        int dashLength = width - headline.length()-1;
        StringBuilder head =new StringBuilder(width);
        for(int i=0; i < dashLength/2;i++)
            head.append('-');
        head.append(' ');
        head.append(headline);
        head.append(' ');
        for(int i=0; i < dashLength/2;i++)
            head.append('-');
        println(head);
        System.out.format(sizeField,"size");
        for(Test test:tests)
            System.out.format(stringField(),test.name);
        println();
    }

    public void timedTest()
    {
        displayHeader();
        for(TestParam param: paramsList)
        {
            System.out.format(sizeField,param.size);
            for(Test<C> test: tests)
            {
                C kontainer = initialize(param.size);
                long start = System.nanoTime();
                int reps = test.test(kontainer,param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration/reps;
                System.out.format(numberField(),timePerRep);
            }
            println();
        }
    }

}
