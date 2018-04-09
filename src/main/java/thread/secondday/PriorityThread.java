package thread.secondday;

public class PriorityThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "  " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        Thread thread = new Thread2();
        thread.start();
    }
}

class Thread1 extends Thread{

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "  " + this.getPriority());
    }
}

class Thread2 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "  " + this.getPriority());
        Thread thread = new Thread1();
        thread.start();
    }
}