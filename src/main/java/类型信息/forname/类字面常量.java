package 类型信息.forname;

import java.util.Random;

public class 类字面常量 {
    public static Random random = new Random(47);
    public static void main(String[] args) throws Exception{

        /*Class cla = c1.class;
        System.out.println(c1.a); // 不会初始化对象，
        System.out.println(c1.b);*/

        Class c = c1.class;
        Class cla = Class.forName("类型信息.forname.c1");

        System.out.println(c.newInstance().getClass() == cla);
    }
}

class c1 {
    static final int a = 41;

    static final int b = 类字面常量.random.nextInt();
    static {
        System.out.println("初始化 c1/..");
    }
}