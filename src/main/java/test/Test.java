package test;
public class Test {

    public static int a = 1;

        private static void testMethod(){
            System.out.println("testMethod");
        }
        /*public static void main(String[] args) {
            (new Test()).testMethod();
        }*/

    public static void main(String[] args) {
        StaticCons s = new StaticCons();
        System.out.println("-----");
        StaticCons s1 = new StaticCons();
    }
}

enum AccountType
{
    SAVING, FIXED, CURRENT;
    private AccountType()
    {
        System.out.println("It is a account type");
    }
}
class EnumOne
{
    public static void main(String[]args)
    {

    }
}


class StaticCons {

    static {
        System.out.println("静态快。。1");
    }

    public StaticCons() {
        System.out.println("构造方法");
    }

    static {
        System.out.println("静态快。。2");
    }

}