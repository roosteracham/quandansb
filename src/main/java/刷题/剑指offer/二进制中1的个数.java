package 刷题.剑指offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class 二进制中1的个数 {
    public int NumberOf1(int n) {

        int result = 0;if(n < 0) {
            n = printComplementCode(n);
        }
        while (n != 0) {
            if (n % 2 == 1) {
                result++;
            }
            n /= 2;
        }
        return result;
    }
    public static int printComplementCode(int a)
    {
        for (int i = 0; i < 32; i++)
        {
            // 0x80000000 是一个首位为1，其余位数为0的整数
            int t = (a & 0x80000000 >>> i) >>> (31 - i);
        }
        return a;
    }
}
