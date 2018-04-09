package 刷题.wangyi;

import java.util.Scanner;

public class 双核处理 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int num = scanner.nextInt();
        scanner.nextLine();
        int[] nums = StringUtil.sortString(scanner.nextLine());

        int sum = StringUtil.sumInts(nums);

        int other = 0;

        int diffa,diffb;
        for (int i = nums.length - 1; i >= 0; i--) {
            diffb = Math.abs(sum - other);
            sum -= nums[i];
            other += nums[i];
            diffa = Math.abs(sum - other);
            if (diffa < diffb) {
                break;
            }
        }

        int time = Math.max(sum, other);
        System.out.println(time);
    }
}
