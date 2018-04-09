package 数据结构.排序.内部排序.选择排序;

/**
 * 简单选择排序
 * 从数组中找出最小的，与当前循环的第一个位置元素交换；
 * 时间复杂度为o(n*n)
 *
 */
public class 简单选择排序 {

    public static void simpleSelectionSort(int[] array) {

        // 每次外层循环执行完，前i个位置的元素已经排好序（从大到小）
        for (int i = 0; i < array.length - 1; i++) {

            int minPos = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }
            if (i != minPos) {
                swapPos(array, i, minPos);
            }
        }
    }

    public static void swapPos(int[] array, int pos1, int pos2) {
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {34,56,78,23,7,4,6,278,234,91,3, 2,4,6,9,0};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        simpleSelectionSort(arr);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
