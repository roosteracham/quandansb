package thread.线程间通信.等待通知机制.基本实现.通知过早;

public class T2 extends Thread {

    WaitService notifyAllService;

    public T2(WaitService notifyAllService) {
        this.notifyAllService = notifyAllService;
    }

    @Override
    public void run() {
        notifyAllService.waiting();
    }
}
