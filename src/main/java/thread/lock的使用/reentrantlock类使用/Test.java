package thread.lock的使用.reentrantlock类使用;

public class Test {

    public static void main(String[] args) {
        Service service = new Service();

        Thread t1 = new T1(service);
        Thread t2 = new T1(service);
        Thread t3 = new T1(service);
        Thread t4 = new T1(service);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
