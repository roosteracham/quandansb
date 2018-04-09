package thread.lock的使用.Condition等待通知线程;


public class T1 extends Thread {
    Service service;

    public T1(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            service.waitMethod();
        }
    }
}
