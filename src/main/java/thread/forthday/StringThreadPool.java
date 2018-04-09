package thread.forthday;

/**
 * String 常量池
 *
 */
public class StringThreadPool {

    public static void main(String[] args) {
        /*String a = "a";
        String b = "a";
        System.out.println(a == b);*/
        
        Serv serv = new Serv();
        StrThread1 strThread1 = new StrThread1(serv);
        strThread1.setName("A");
        strThread1.start();


        StrThread2 strThread2 = new StrThread2(serv);
        strThread2.setName("B");
        strThread2.start();
    }
}


class Serv {
    public void print(String string) throws InterruptedException{
        //string = new String();
        /**
         * 如果不同线程传过来的string是相同的，因为String常量池的原因，其实不同线程传递的是同一个对象
         * 所以会产生竞争
         */
        synchronized (string) {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }
    }
}

class StrThread1 extends Thread {
    
    Serv serv;
    public StrThread1(Serv serv) {
        this.serv = serv;
    }
    @Override
    public void run() {
        
        try {

            serv.print("A");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class StrThread2 extends Thread {

    Serv serv;
    public StrThread2(Serv serv) {
        this.serv = serv;
    }
    @Override
    public void run() {

        try {

            serv.print("A");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}