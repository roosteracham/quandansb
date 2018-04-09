package thread.lock的使用.reentrantlock类使用;

public class T1 extends Thread{

    Service service;

    public T1(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.service();
    }
}
