package thread.线程间通信.threadlocal;

public class Test {

    private static ThreadLocal threadLocal = new ThreadLocal();
    public static void main(String[] args) {
        System.out.println(threadLocal.get());
        threadLocal.set("a");
        System.out.println(threadLocal.get());
        threadLocal.set("b");
        threadLocal.set("c");
        System.out.println(threadLocal.get());
    }
}

class TL extends ThreadLocal {
    @Override
    protected Object initialValue() {
        return new Object();
    }
}