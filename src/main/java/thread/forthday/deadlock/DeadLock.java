package thread.forthday.deadlock;

/**
 * 两线程互相等待对方释放锁会造成死锁现象
 */
public class DeadLock {

    static Service service = new Service();

    public static void main(String[] args) throws InterruptedException{
        service.setName("a");
        Runnable r1 = new T1(service);
        Thread t1 = new Thread(r1);
        t1.start();
        Thread.sleep(100);
        service.setName("b");
        Thread t2 = new Thread(new T2(service));
        t2.start();
    }

}

class Service {
    String name;
    Object lock1 = new Object();
    Object lock2 = new Object();
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 两线程互相等待对方释放锁会造成死锁现象
     */
    public void service() {
        if ("a".equals(name)) {
            synchronized (lock1) {
                try {

                    System.out.println("a");
                    Thread.sleep(3000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("a --> b");
                }
            }
        }

        if ("b".equals(name)) {
            synchronized (lock2) {
                try {

                    System.out.println("b");
                    Thread.sleep(3000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("b --> a");
                }
            }
        }
    }
}

class T1 implements Runnable {
    Service service;

    public T1(Service service) {
        this.service = service;
    }

    public void run() {
        service.service();
    }
}


class T2 implements Runnable {
    Service service;

    public T2(Service service) {
        this.service = service;
    }

    public void run() {
        service.service();
    }
}