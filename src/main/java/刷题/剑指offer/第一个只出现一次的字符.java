package 刷题.剑指offer;

/**
 * 题目描述
 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class 第一个只出现一次的字符 {
    public static int FirstNotRepeatingChar(String str) {
        if (str.equals("")) {
            return -1;
        }
        if (str.length() == 1) {

            return 0;
        }
        int i = 0;
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!str.substring(i + 1, str.length()).contains(String.valueOf(c)) &&
                    !str.substring(0, i).contains(String.valueOf(c))) {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("google"));
        System.out.println("google".substring(1, 6));
    }
}
