package 刷题.剑指offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class 跳台阶 {
    public static int JumpFloor(int target) {

        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int _2time = target / 2;
        int time = _2time;
        if (target % 2 != 0) {
            time++;
        }
        int result = 0;
            for (int i = 0; i <= _2time; i++) {
                result += com(time + 1 * i, _2time - i);
            }

        return  result;
    }
   static long com(int num, int time) {
        if (time == 0) {
            return 1;
        }
       long result = 1;
        for (int i = 1; i <= time; i++) {
            int j = num - i + 1;
            result *= (j);
        }
        for (int i = 1; i <= time; i++) {
            result /= i;
        }
        return result;
    }

    static int p(int n) {
        if (n == 1) {
            return 1;
        }
        return n * p(n - 1);
    }
    public static void main(String[] args) {
        System.out.println(com(15, 14));
    }
}
