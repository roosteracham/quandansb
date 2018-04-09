package exception;

public class MyException {

    public static void main(String[] args) {
        child2 c = new child2();
        c.c2();
    }
}

class Excep1 extends RuntimeException {

    private static final long id = 5;

    private String errorCode;

    private boolean propertiesKey;

    public Excep1(String message) {
        super(message);
    }

    public Excep1(String message, Throwable cause) {
        super(message, cause);
    }

    public Excep1() {
        super();
    }
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isPropertiesKey() {
        return propertiesKey;
    }

    public void setPropertiesKey(boolean propertiesKey) {
        this.propertiesKey = propertiesKey;
    }
}


class father {


    public  father() {
        System.out.println("father");
    }
    public void a() {
        System.out.println("a");
    }

    public void b() {
        System.out.println("b");
    }
}

class child1 extends father {}

class  child2 extends father {

    public child2() {
        super();
        System.out.println("c2");
    }
    public void c2() {
        super.a();
        super.b();
    }

    @Override
    public void a() {
        super.a();
    }
}