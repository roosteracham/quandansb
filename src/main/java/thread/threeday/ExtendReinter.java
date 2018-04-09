package thread.threeday;

public class ExtendReinter {

    public static void main(String[] args) {
        ThreadExtends threadExtends = new ThreadExtends();
        threadExtends.start();
    }
}

class Father {
    int num = 10;

    public synchronized void father() throws InterruptedException{
        num--;
            System.out.println("father : " + num);
            Thread.sleep(100);
    }
}

class Child extends Father {
    public synchronized void father() throws InterruptedException{
        while (num-- > 0) {
            System.out.println("child : " + num);
            Thread.sleep(100);
            super.father();
        }
    }
}

class ThreadExtends extends Thread{

    @Override
    public void run() {
        try {

            super.run();
            Father father = new Father();
            father.father();
        }catch (InterruptedException e ) {
            e.printStackTrace();
        }
    }
}