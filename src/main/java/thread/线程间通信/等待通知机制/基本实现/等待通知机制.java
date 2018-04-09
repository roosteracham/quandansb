package thread.线程间通信.等待通知机制.基本实现;

public class 等待通知机制 {

    public static void main(String[] args) {
        //new String().wait();

        Object lock = new Object();

        Thread t1 = new T1(lock);
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new T2(lock);
        t2.start();
    }
}

class T1 extends Thread {

    Object lock;
    
    public T1(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        System.out.println("T1 同步方法之上");
        synchronized (lock) {

            System.out.println("T1 wait方法之上");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T1 wait方法之下");
        }
        System.out.println("T1 同步方法之下");
    }
}


class T2 extends Thread {

    Object lock;

    public T2(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        System.out.println("T2 同步方法之上");
        synchronized (lock) {

            System.out.println("T2 wait方法之上");
                lock.notify();
            System.out.println("T2 wait方法之下");
        }
        System.out.println("T2 同步方法之下");
    }
}