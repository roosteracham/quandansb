package 数据结构.排序.内部排序.插入排序;

/**
 * 将待排序序列分为两部分，有序序列和无需序列，
 * 每次从无序序列中去一个元素，与有序序列中元素比较大小，并插入到相应位置
 *
 * 时间复杂度为o(n*n)，对有序序列的时间复杂度为o(n)
 */
public class 简单插入排序 {
    
    public static void simpleInsertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swapPos(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void simpleInsertionSort(int[] array, int left, int right) {

        int length = right - left;
        for (int i = left + 1; i <= right; i++) {
            for (int j = i; j > left; j--) {
                if (array[j] < array[j - 1]) {
                    swapPos(array, j, j - 1);
                } else {
                    break;
                }
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
        simpleInsertionSort(arr, 3,6);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
