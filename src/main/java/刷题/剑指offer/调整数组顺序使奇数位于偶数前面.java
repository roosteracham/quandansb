package 刷题.剑指offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public void reOrderArray(int [] array) {


        List<Integer> odds = new LinkedList<>();
        List<Integer> evens = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evens.add(array[i]);
            }else {
                odds.add(array[i]);
            }
        }
        int i = 0;
        while (!odds.isEmpty()) {
            array[i] = odds.remove(0);
            i++;
        }
        while (!evens.isEmpty()) {
            array[i] = evens.remove(0);
            i++;
        }
    }

    public static void swapPos(int[] array, int pos1, int pos2) {
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
}
