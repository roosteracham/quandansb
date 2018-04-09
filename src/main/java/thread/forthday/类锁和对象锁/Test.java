package thread.forthday.类锁和对象锁;

public class Test {

    public static void main(String[] args) throws InterruptedException{
        ClassSyn cl = new ClassSyn();
        T1 t1 = new T1(cl);
        t1.start();
        Thread.sleep(100);
        T2 t2 = new T2(cl);
        t2.start();
    }
}
