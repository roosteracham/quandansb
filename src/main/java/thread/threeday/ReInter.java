package thread.threeday;

public class ReInter {
    public static void main(String[] args) {

        Thread thread = new T1(new ReIn());
        thread.start();
    }
}

class ReIn {
    public synchronized void s1 () {
        System.out.println("get in s1");
        s2();
    }
    public synchronized void s2 () {
        System.out.println("get in s2");
        s3();
    }
    public synchronized void s3 () {
        System.out.println("get in s3");
    }
}

class T1 extends Thread {

    private ReIn reIn;
    public T1(ReIn reIn) {
        this.reIn = reIn;
    }
    @Override
    public void run() {
        super.run();
        reIn.s1();
    }
}