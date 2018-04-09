package thread.线程间通信.等待通知机制.基本实现.通知过早;

import java.util.List;

public class WaitService {

    String str;

    List list;
    public WaitService(String s, List list) {
        this.str = s;
        this.list = list;
    }

    public void waiting() {

        synchronized (str) {
            while (list.size() == 0) {
                System.out.println("wait begins : " + Thread.currentThread().getName());
                try {
                    str.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait end : " + Thread.currentThread().getName());
            }
            list.remove(0);
            System.out.println("wait exists : " + Thread.currentThread().getName());
        }
    }
}
