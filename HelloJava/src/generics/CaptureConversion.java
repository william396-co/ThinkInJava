package generics;

public class CaptureConversion {

    static <T> void f1(Holder<T> holder)
    {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static <T> void f2(Holder<T> holder)
    {
        f1(holder);
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);
        f1(raw);
        f2(raw);
    }
}
