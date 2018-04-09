package thread.线程间通信.等待通知机制.基本实现.通知过早;

import java.util.List;

public class NotifyAllService {

    String str;

    List list;
    public NotifyAllService(String s, List list) {
        this.str = s;
        this.list = list;
    }

    public void notifyall() {
        synchronized (str) {
            list.add("anyString");
            str.notifyAll();
            System.out.println("t通知等待的线程。");
        }
    }
}
