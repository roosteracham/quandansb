package thread.secondday;

public class YieldThread {

    public static void main(String[] args) {

        Thread thread = new YieldClass();
        thread.start();
    }
}

class YieldClass extends Thread{

    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 5000000; i++) {
            //Thread.yield();
            count += i + 1;
        }
        long end = System.currentTimeMillis();
        System.out.println("时间： " + (begin - end));
    }
}