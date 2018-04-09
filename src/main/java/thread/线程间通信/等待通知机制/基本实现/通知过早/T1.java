package thread.线程间通信.等待通知机制.基本实现.通知过早;

public class T1 extends Thread {

    NotifyAllService notifyAllService;

    public T1(NotifyAllService notifyAllService) {
        this.notifyAllService = notifyAllService;
    }

    @Override
    public void run() {
        notifyAllService.notifyall();
    }
}
