package thread.firstday;

public class Test3 {
    public static void main(String[] args) {
        /*Demo3 demo3 = new Demo3();
        Thread thread1 = new Thread(demo3, "A");
        Thread thread2 = new Thread(demo3, "B");
        Thread thread3 = new Thread(demo3, "C");
        Thread thread4 = new Thread(demo3, "D");
        Thread thread5 = new Thread(demo3, "E");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();*/

        /*UnsafeThread1 t1 = new UnsafeThread1();
        UnsafeThread2 t2 = new UnsafeThread2();
        t1.start();*/
        //t2.start();
        CurrentThread thread = new CurrentThread();
        Thread t = new Thread(thread);
        thread.setName("a");
        t.start();
    }
}
