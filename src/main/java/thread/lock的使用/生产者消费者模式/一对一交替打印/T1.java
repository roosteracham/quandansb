package thread.lock的使用.生产者消费者模式.一对一交替打印;

public class T1 extends Thread {

    Service service;

    public T1(Service service) {
        this.service = service;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            service.get();
        }
    }
}
