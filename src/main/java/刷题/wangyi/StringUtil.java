package 刷题.wangyi;

import java.util.*;

public class StringUtil {


    //统计字符串出现的字符及其出现的个数
    public static Map<String, Integer> stringToChars(String string) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            String key = String.valueOf(string.charAt(i));
            if (map.containsKey(key)) {

                int num = map.get(key);
                map.put(key, ++ num);
            } else {
                map.put(key, 1);
            }
        }
        return map;
    }

    // 输入一串数字，以空格分隔，将其转化为从小到大的数组
    public static int[] sortString(String string) {

        int[] origin = stringToInts(string, " ");
        Arrays.sort(origin);

        return origin;
    }

    // 输入一串数字，以空格分隔，将其转化数组
    public static int[] stringToInts(String string, String pattern) {
        String[] strings = string.split(pattern);

        int[] origin = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            origin[i] = Integer.parseInt(strings[i]);
        }

        return origin;
    }

    //循环读取数字
    public static int[] getInputNumber(int size, Scanner scanner) {
        int[] userLike = new int[size];
        for (int i = 0; i < size; i++) {
            userLike[i] = scanner.nextInt();
        }
        return userLike;
    }
    public static int[] stringToInts(String string) {

        int[] origin = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
            origin[i] = Integer.parseInt(String.valueOf(string.charAt(i)));
        }

        return origin;
    }

    // 整形数组求和
    public static int sumInts(int[] ints) {
        int sum = 0;

        for (int i : ints) {
            sum += i;
        }
        return sum;
    }

    //
    public static List<Integer> inputNumberToList(int num, Scanner scanner, List list) {

        for (int i = 0; i < num; i++) {
            list.add(scanner.nextInt());
        }
        return list;
    }
}
