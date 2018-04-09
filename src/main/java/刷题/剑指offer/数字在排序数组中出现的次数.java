package 刷题.剑指offer;

import 刷题.今日头条.BinarySearch;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class 数字在排序数组中出现的次数 {
    public static int GetNumberOfK(int [] array , int k) {

        int times = 0;
        int start = BinarySearch.firstlyOccursPos(array, k);
        int last = BinarySearch.lastOccursPos(array, k);
        if (start == -1 && last == -1) {
            times = 0;
        }else {
            times = last - start + 1;
        }
        return times;
    }

    public static void main(String[] args) {
        int[] a = {3,3,3,3,4,5};
        System.out.println(GetNumberOfK(a, 3));
    }
}
