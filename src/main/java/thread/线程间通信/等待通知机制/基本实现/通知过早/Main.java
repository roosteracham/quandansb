package thread.线程间通信.等待通知机制.基本实现.通知过早;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        String string = "123";
        List list = new ArrayList();
        WaitService waitService = new WaitService(string, list);
        NotifyAllService notifyAllService = new NotifyAllService(string, list);
        T2 t1 = new T2(waitService);
        t1.start();
        T2 t2 = new T2(waitService);
        t2.start();
        Thread.sleep(1000);
        T1 t3 = new T1(notifyAllService);
        t3.start();
    }
    
}
