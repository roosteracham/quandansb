package 刷题.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
 1、将a_i放入b序列的末尾
 2、逆置b序列
 小易需要你计算输出操作n次之后的b序列。
 输入描述:
 输入包括两行,第一行包括一个整数n(2 ≤ n ≤ 2*10^5),即序列的长度。
 第二行包括n个整数a_i(1 ≤ a_i ≤ 10^9),即序列a中的每个整数,以空格分割。


 输出描述:
 在一行中输出操作n次之后的b序列,以空格分割,行末无空格。

 输入例子1:
 4
 1 2 3 4

 输出例子1:
 4 2 1 3
 */
public class 操作序列 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // 注释的代码复杂度太高，超时
        /*List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            list.add(num);
            Collections.reverse(list);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) {
                System.out.print(" ");
            }
        }*/

        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            if (i % 2 == 0) {
                evens.add(scanner.nextInt());
            } else {
                odds.add(scanner.nextInt());
            }
        }

        if (n % 2 == 0) {
            for (int i = evens.size() - 1; i >= 0; i--) {
                System.out.print(evens.get(i) + " ");
            }
            for (int i = 0; i < odds.size(); i++) {
                System.out.print(odds.get(i));
                if (i == odds.size() - 1) {
                    System.out.print(" ");
                }
            }
        } else {
            for (int i = odds.size() - 1; i >= 0; i--) {
                System.out.print(odds.get(i) + " ");
            }
            for (int i = 0; i < evens.size(); i++) {
                System.out.print(evens.get(i));
                if (i != evens.size() - 1) {
                    System.out.print(" ");
                }
            }
        }
    }
}
