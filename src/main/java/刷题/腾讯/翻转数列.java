package 刷题.腾讯;

import java.util.Scanner;

/**
 * <div class="subject-question"><span>小Q定义了一种数列称为翻转数列:</span><br>
 *     <span>给定整数n和m, 满足n能被2m整除。对于一串连续递增整数数列1, 2, 3, 4..., 每隔m个符号翻转一次, 最初符号为'-';。</span><br>
 *         <span>例如n = 8, m = 2, 数列就是: -1, -2, +3, +4, -5, -6, +7, +8.</span><br>
 *             <span>而n = 4, m = 1, 数列就是: -1, +2, -3, + 4.</span><br>
 *     <span>小Q现在希望你能帮他算算前n项和为多少。</span></div>
 */
public class 翻转数列 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int m = scanner.nextInt();

        if (n % (2 * m) != 0) {
            return;
        }
        boolean change = false;

        long sum = 0;
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!change) {
                sum += (-1) * i;
                count++;
                if (count == m) {
                    change = true;
                    count = 0;
                }
            } else {
                sum += i;
                count++;
                if (count == m) {
                    change = false;
                    count = 0;
                }
            }

        }
        System.out.println(sum);
    }
}
