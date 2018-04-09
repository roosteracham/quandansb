package thread.firstday;

public class Demo3 extends Thread {
    private int count = 5;
    @Override
     public void run() {
        //super.run();
        //count--;
        System.out.println("now is thread " + this.currentThread().getName() + " 计算 count " + --count);
    }
}
