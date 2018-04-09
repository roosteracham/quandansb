package thread.firstday;

public class Test4 {
    public static void main(String[] args) {
        MyThread2 thread2 = new MyThread2();
        Thread thread = new Thread(thread2);
        thread.start();
    }
}
class MyThread2 implements Runnable{

    public MyThread2() {
        System.out.println("构造方法打印： " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
    }
    @Override
    public void run() {
        System.out.println("run方法打印： " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
    }
}

class TestThread extends Thread {
    @Override
    public void run() {
        System.out.println("run is " + this.isAlive());
    }
}