package thread.lock的使用.生产者消费者模式.一对一交替打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Service {
    Lock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    boolean flag = false;
    public void set() {
        try {
            lock.lock();
            while (flag == false){
                System.out.println("交替出现1111111111");
                condition.await();
            }
            System.out.println("☆");
            flag = false;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (flag == true){
                System.out.println("交替出现222222222");
                condition.await();
            }
            System.out.println("★");
            flag = true;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
