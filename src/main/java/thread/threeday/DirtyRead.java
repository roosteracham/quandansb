package thread.threeday;

import java.io.IOException;

public class DirtyRead {

    public static void main(String[] args) throws InterruptedException{

        Dirty dirty = new Dirty();
        Thread thread = new Thread1(dirty);
        thread.start();
        Thread.sleep(200);
        dirty.getval();
    }
}
class Dirty {
    private String name = "A";
    private String pwd = "aa";
    public synchronized void setval(String name, String pwd) {
        try {
            this.name = name;
            Thread.sleep(5000);
            this.pwd = pwd;
            System.out.println("Thread.currentThread().getName(): " + Thread.currentThread().getName()
                    + "name : " + this.name + "pwd : " + this.pwd);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void getval() {
        System.out.println("Thread.currentThread().getName(): " + Thread.currentThread().getName()
                + " name : " + this.name + " pwd : " + this.pwd);
    }
}

class Thread1 extends Thread{

    private Dirty dirty;
    public Thread1(Dirty dirty) {
        this.dirty = dirty;
    }

    @Override
    public void run() {
        super.run();
        dirty.setval("B", "bb");
    }
}