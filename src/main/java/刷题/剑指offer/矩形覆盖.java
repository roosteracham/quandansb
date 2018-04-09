package 刷题.剑指offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class 矩形覆盖 {
    public int RectCover(int target) {

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
    long com(int num, int time) {
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
}
