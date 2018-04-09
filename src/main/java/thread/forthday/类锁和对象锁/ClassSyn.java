package thread.forthday.类锁和对象锁;

/**
 * 类锁和对象锁不是一类锁
 *
 */
public class ClassSyn {

    public void a(String string) {
        synchronized (ClassSyn.class) {

            System.out.println("a method  " + string);
                b("a");
        }
    }


    public void b(String string) {
        synchronized (this) {
            try {
                System.out.println("b method sleeps " + string);
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b method  " + string);
        }
    }
}

class T1 extends Thread {
    ClassSyn classSyn;
    public T1(ClassSyn classSyn) {
        this.classSyn = classSyn;
    }

    @Override
    public void run() {
        super.run();
        classSyn.a("t1");
    }
}

class T2 extends Thread {
    ClassSyn classSyn;
    public T2(ClassSyn classSyn) {
        this.classSyn = classSyn;
    }

    @Override
    public void run() {
        super.run();
        classSyn.b("t2");
    }
}