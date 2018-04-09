package thread.lock的使用.生产者消费者模式.一对一交替打印;

public class Test {

    public static void main(String[] args) {

        Service service = new Service();

        /*Thread t1 = new T1(service);
        Thread t2 = new T2(service);

        t1.start();
        t2.start();*/

        Thread[] threadsa = new T1[10];

        Thread[] threadsb = new T2[10];

        for (int i = 0; i < 10; i++) {
            threadsa[i] = new T1(service);
            threadsb[i] = new T2(service);

            threadsa[i].start();
            threadsb[i].start();
        }
    }
}
