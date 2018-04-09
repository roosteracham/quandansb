package thread.线程间通信.等待通知机制.基本实现;

public class NotifyAndNotifyAll {

    public static void main(String[] args) {
        Object lock = new Object();

        Thread t1 = new T3(lock);
        t1.start();

        Thread t3 = new T3(lock);
        t3.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new T4(lock);
        t2.start();
    }
}


class T3 extends Thread {

    Object lock;

    public T3(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock) {

            System.out.println("T3 wait方法之上");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T3 wait方法之下");
        }
    }
}


class T4 extends Thread {

    Object lock;

    public T4(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock) {

            System.out.println("T4 wait方法之上");
            lock.notifyAll();
            System.out.println("T4 wait方法之下");
        }
    }
}