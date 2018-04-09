package thread.firstday;

public class Test {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
       // FirstThreadDemo firstThreadDemo = new FirstThreadDemo();
        //firstThreadDemo.start();

        /*try {
            FirstThreadDemo firstThreadDemo = new FirstThreadDemo();
            firstThreadDemo.setName("firstThread");
            firstThreadDemo.start();
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main = " +  Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Runnable runnable = new RunnableDemo();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("end..");
    }
}
