package 刷题.wangyi;

import java.util.Scanner;

/**
 * 小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。一个人生活增加了许多花费:
 * 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。当前小易手中已经有f个水果和d元钱,
 * 小易也能去商店购买一些水果,商店每个水果售卖p元。
 * 小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,小易希望你来帮他计算一下他最多能独立生活多少天。
 * 1 1996245611 1999990159 123
 *  1996275808
 *
 *  上面是个坑，如果属于int类型的变量是不合适的，int 容纳不了那么大的话
 *
 */
public class 独立的小易 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int[] nums = StringUtil.stringToInts(scanner.nextLine(), " ");

        long x= nums[0], f =  nums[1], d = nums[2], p = nums[3];
        long day = (d + f * p) / (x + p);

        long a = day * x;
        day = a < d ? day : d / x;
        System.out.println(day);
    }
}
