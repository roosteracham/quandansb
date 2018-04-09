package 刷题.wangyi;

import java.util.Scanner;

public class 相反数 {

    public static void main(String[] args) {

        int num = new Scanner(System.in).nextInt();
        String string1 = num + "";
        String string = "";
        for (int i = string1.length() - 1; i >= 0; i--) {
            String c = String.valueOf(string1.charAt(i));



            if (i == string1.length() && !c.equals("0")) {
                string = string + c;
            } else {
                string = string + c;
            }
        }

        System.out.println(num + Integer.parseInt(string));
    }
}
