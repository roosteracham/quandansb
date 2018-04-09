package thread.firstday;

public class StopThread {

    public static void main(String[] args) {
        /*try {
            *//*Thread stopClass = new StopClass();
            //stopClass.start();
            Thread.sleep(500);
            stopClass.interrupt();
            //System.out.println("是否停止 " + stopClass.interrupt(););
            Thread.currentThread().interrupt();
            System.out.println("是否停止 " + stopClass.isInterrupted());
            //stopClass.isInterrupted();
            System.out.println("是否停止2 " + Thread.interrupted());

            System.out.println("是否停止3 " + Thread.interrupted());*//*

        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Thread thread = new StopClass3();
        thread.start();
    }
}
class StopClass extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("i = " + (i + 1));
        }
    }
}

class StopClass2 extends Thread{

    @Override
    public void run() {
        try {
            for (int i = 0; i < 500000; i++) {
            if (this.isInterrupted()) {
                System.out.println("推出");

                    throw new InterruptedException();
                }

            System.out.println("i = " + (i + 1));}
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("jixuzhix。。");
    }
}

class StopClass3 extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName() + " is running");
        this.stop();
        System.out.println(Thread.currentThread().getName() + " is still running");
    }
}