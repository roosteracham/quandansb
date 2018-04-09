package thread.firstday;

public class CurrentThread extends Thread{
    public CurrentThread(){
        System.out.println("Cur...");
        System.out.println("TH" + Thread.currentThread().getName());
        System.out.println("name"+this.getName());
    }

    @Override
    public void run(){
        System.out.println("run...");
        System.out.println("TH" + Thread.currentThread().getName());
        System.out.println("name"+this.getName());
    }
}
