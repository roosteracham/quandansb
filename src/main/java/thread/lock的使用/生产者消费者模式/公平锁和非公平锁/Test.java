package thread.lock的使用.生产者消费者模式.公平锁和非公平锁;

public class Test {

    public static void main(String[] args) {

        final FairLockService service = new FairLockService(false);

        Runnable runnable = new Runnable() {
            /**
             * 这个不是同步的方法
             */
            public void run() {
                System.out.println("线程 【" + Thread.currentThread().getName() +
                "】 开始运行。。");
                service.service();
            }
        };


        Thread[] threadsa = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadsa[i] = new Thread(runnable);
        }

        for (int i = 0; i < 10; i++) {
            threadsa[i].start();
        }
    }
}
