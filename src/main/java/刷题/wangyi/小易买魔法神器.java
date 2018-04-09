package 刷题.wangyi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 小易买魔法神器{
    public static void main(String[] args) {

        List lists = new ArrayList();

        while (true) {

            int num = new Scanner(System.in).nextInt();

            while (num != 0) {
                // 偶数
                if (num % 2 == 0) {
                    num = (num - 2) / 2;
                    lists.add("2");
                } else {
                    num = (num - 1) / 2;
                    lists.add("1");
                }
            }
            Collections.reverse(lists);
            for (int i = 0; i < lists.size(); i++) {
                System.out.print(lists.get(i));
            }
            System.out.println();
            lists.clear();
        }
    }
}
