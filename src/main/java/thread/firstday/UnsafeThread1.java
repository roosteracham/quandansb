package thread.firstday;

public class UnsafeThread1 extends Thread{
    @Override
    public void run() {
        super.run();
        Login.doPost("a", "aa");
    }
}
