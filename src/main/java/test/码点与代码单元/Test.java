package test.码点与代码单元;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Test {

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

        ActionListener al = new TestLisner();

        Timer timer = new Timer(1000, al);
        timer.start();

        JOptionPane.showMessageDialog(null, "quit?");
    }
}

class TestLisner implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("at the tone, the time is : " + new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
