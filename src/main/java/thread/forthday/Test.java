package thread.forthday;

/**
 * synchronized 修饰的静态方法，作为于类的所有对象，就是说所有的对象都是同步的访问这个方法，
 * 但是可以一部访问其他的未同步的方法或者加了对象所的方法
 */
public class Test {

    public static void main(String[] args) {
        Service ser = new Service();
        Thread a = new Thread1(ser);
        a.setName("threada");
        a.start();
        Thread b = new Thread2(ser);
        b.setName("threadb");
        b.start();
        Thread c = new Thread3(ser);
        c.setName("threadc");
        c.start();


    }
}

class Service {
    synchronized public static void a() throws InterruptedException{
        System.out.println("Thread.currentThread().getName() " + Thread.currentThread().getName()
                + " a begin");
        Thread.sleep(1000);
        System.out.println("Thread.currentThread().getName() " + Thread.currentThread().getName()
                + " a end");
    }

     synchronized public static void b() throws InterruptedException{

            System.out.println("Thread.currentThread().getName() " + Thread.currentThread().getName()
                    + " b begin");
            Thread.sleep(100);
            System.out.println("Thread.currentThread().getName() " + Thread.currentThread().getName()
                    + " b end");
    }
    synchronized public void c() throws InterruptedException{
        System.out.println("Thread.currentThread().getName() " + Thread.currentThread().getName()
                + " c begin");
        Thread.sleep(100);
        System.out.println("Thread.currentThread().getName() " + Thread.currentThread().getName()
                + " c end");
    }
}


class Thread1 extends Thread {
    private Service service;
    public Thread1(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        try {

            service.a();
    }catch (InterruptedException e) {
        e.printStackTrace();
    }
    }
}

class Thread2 extends Thread {
    private Service service;
    public Thread2(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        try {
            service.b();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Thread3 extends Thread {
    private Service service;
    public Thread3(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        try {
            service.c();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}