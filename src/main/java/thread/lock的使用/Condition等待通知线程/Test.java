package thread.lock的使用.Condition等待通知线程;

public class Test {

    public static void main(String[] args) throws InterruptedException{
        Service service = new Service();

        Thread t1 = new T1(service);
        
        t1.start();

        Thread.sleep(2000);

        service.notifyMethod();
    }
}
