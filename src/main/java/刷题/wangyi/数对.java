package 刷题.wangyi;

import java.util.Scanner;

public class 数对 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int result = 0;
        String string = "";
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                if ((i % j) >= k) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
