package test.码点与代码单元;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;

public class Test2 {

    public static void main(String[] args) {
        /*String string = "hello";
        System.out.println(string.length());
        System.out.println(string.codePointCount(2, string.length()));
        int index = string.offsetByCodePoints(1,2);
        System.out.println(index + " " + string.codePointAt(index));
        System.out.println((char)108);*/
/*
        char[] c = Character.toChars(Integer.parseInt("1D306", 16));//1D306是一个辅助平面字符
        System.out.println(Character.codePointAt(c, 0));//输出119558，这个是1D306对应的10进制值
        System.out.println(Character.codePointAt(c, 1));//输出57094，这个是c[1]对应字符的10进制值*/
        /*char c = '\u2122';
        System.out.println(c);*/

        MyCollection[] mcs = new MyCollection[5];
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            mcs[i] = new MyCollection(random.nextInt(), i);
        }

        String[] s = {"paul", "pete", "peter"};

        Arrays.sort(s, new MyComparator(1,2));
        Arrays.sort(mcs);
        System.out.println();
    }
}

class MyCollection implements Comparable {

    public MyCollection(int age, int serial) {
        this.age = age;
        this.serial = serial;
    }

    private int age;

    private int serial;

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        return this.age - ((MyCollection)o).getAge();
    }
}


class MyComparator implements Comparator<String> {

    public MyComparator(int age, int serial) {
        this.age = age;
        this.serial = serial;
    }

    private int age;

    private int serial;

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}