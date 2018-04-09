package test.firstday;

import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.net.InetAddress;

public class test1 {

    public static void main(String[] args) throws Exception{

        /*InetAddress address =InetAddress.getLocalHost();
        String s = address.getHostName();//获取计算机名
        String s2 = address.getHostAddress();//获取IP地址
        byte[] bytes = address.getAddress();//获取字节数组形式的IP地址,以点分隔的四部分*/

        /*test1 t = new test1();
        Thread.sleep(60*1000);
        t = new test1();*/

        Integer i1 = 6;
        Integer i2 = 6;
        System.out.println((i1==i2));//true


        Integer i3 = new Integer(6);
        Integer i4 = new Integer(6);

        System.out.println((6==i3));
        System.out.println((128==i3));
        System.out.println((i4==128));

        System.out.println((i3==i4)+" "+i3.hashCode()+" "+i4.hashCode());

    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalized..");
    }
    public test1() {
        System.out.println("constructed");
    }
}