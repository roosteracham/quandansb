package 刷题.wangyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 彩色的砖块 {


    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //int num = scanner.nextInt();
        String line = scanner.nextLine();

        char[] c = new char[line.length()];
        //map.put(String.valueOf(line.charAt(0)), 0);

        map = StringUtil.stringToChars(line);
        //System.out.println(c);

        int size = map.size();

        if (size == 1) {
            System.out.println("1");
        } else if (size > 2) {
            System.out.println("0");
        } else {
            System.out.println(size * (size - 1));
        }
    }


    //统计字符串出现的字符及其出现的个数
    static void stringToChars(String string, char[] c) {

        for (int i = 0; i < c.length; i++) {
            c[i] = string.charAt(i);
            String key = String.valueOf(String .valueOf(c[i]));
            if (map.containsKey(key)) {

                int num = map.get(String.valueOf(String .valueOf(c[i])));
                map.put(String.valueOf(String .valueOf(c[i])), ++ num);
            } else {
                map.put(key, 1);
            }
        }
    }
}
