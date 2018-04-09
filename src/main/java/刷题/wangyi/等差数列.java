package 刷题.wangyi;

import java.util.Scanner;

/**
 * 如果一个数列S满足对于所有的合法的i,都有S[i + 1] = S[i] + d, 这里的d也可以是负数和零,我们就称数列S为等差数列。
 * 小易现在有一个长度为n的数列x,小易想把x变为一个等差数列。小易允许在数列上做交换任意两个位置的数值的操作,
 * 并且交换操作允许交换多次。但是有些数列通过交换还是不能变成等差数列,
 * 小易需要判别一个数列是否能通过交换操作变成等差数列
 */
public class 等差数列 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        if (num == 1) {

            System.out.println("Possible");
            return;
        }
        scanner.nextLine();
        String line = scanner.nextLine();

        int[] sorted = StringUtil.sortString(line);

        int d = sorted[0] - sorted[1];

        for (int i = 0; i < sorted.length - 1; i++) {
            int diff = sorted[i] - sorted[i + 1];

            if (d != diff) {
                System.out.println("Impossible");
                return;
            }
        }

        System.out.println("Possible");
    }
}
