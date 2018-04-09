package thread.lock的使用.生产者消费者模式.公平锁和非公平锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockService {

    Lock lock;

    public FairLockService(boolean fair) {
        this.lock = new ReentrantLock(fair);
    }

    public void service() {

        try {
            lock.lock();

            System.out.println("线程 【" + Thread.currentThread().getName() + "】 获得锁");
        }finally {
            lock.unlock();
        }
    }
}
