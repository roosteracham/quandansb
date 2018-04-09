package thread.lock的使用.reentrantlock类使用;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service {

    Lock lock = new ReentrantLock();

    public void service() {
        lock.lock();

        for (int i = 0; i < 5;) {
            System.out.println("Thread.currentThread().getName() " +
                    Thread.currentThread().getName() + " " + ++i);
        }
        lock.unlock();
    }
}
