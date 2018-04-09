package thread.firstday;

public class UnsafeThread2 extends Thread{
    @Override
    public void run() {
        super.run();
        Login.doPost("b", "bb");
    }
}
