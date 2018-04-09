package 刷题.wangyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * 如果一个01串任意两个相邻位置的字符都是不一样的,我们就叫这个01串为交错01串。例如: "1","10101","0101010"都是交错01串。
 * 小易现在有一个01串s,小易想找出一个最长的连续子串,并且这个子串是一个交错01串。小易需要你帮帮忙求出最长的这样的子串的长度是多少。
 * 输入 111101111
 *  输出 3
 */
public class 交错01串 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        int[] ints = StringUtil.stringToInts(string);
        Map<Integer, Integer> map = new HashMap<>();
        int times = 0;

        int max = 0;
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] - ints[i + 1] != 0) {
                if (map.containsKey(times)) {

                    int num = map.get(times);
                    map.put(times, ++num);
                } else {
                    map.put(times, 2);
                }
            } else {
                times++;
            }
        }
        if (map.size() == 0) {
            System.out.println("1");
            return;
        }
        for (int i = 0; i < ints.length; i++) {
            if (map.containsKey(i)) {
                int num = map.get(i);
                if (max < num) {
                    max = num;
                }
            }
        }
        System.out.println(max);
    }
}
