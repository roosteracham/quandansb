package 刷题.wangyi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 字符串碎片 {
    public static void main(String[] args) {
        String string = new Scanner(System.in).next();
        List list = new ArrayList();
        int j = 0, n = 1;
        list.add(0);
        for (int i = 0; i < string.length() - 1; i++) {
            String a = String.valueOf(string.charAt(i));
            String b = String.valueOf(string.charAt(i + 1));
            //list.add(0);
            // aaabbaaac
            if (a.equals(b)) {
            }else {
                list.add(0);
            }
        }
        DecimalFormat df = new DecimalFormat("##0.00");
        System.out.println(df.format(Math.round(string.length() * 100.0 / list.size()) / 100.0));
    }
}
