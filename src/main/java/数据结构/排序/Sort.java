package 数据结构.排序;

import 数据结构.binarytree.堆.Heap;
import 数据结构.binarytree.堆.MaxHeap;
import 数据结构.排序.内部排序.插入排序.简单插入排序;

public class Sort {

    /**
     * 简单选择排序
     * 从数组中找出最小的，与当前循环的第一个位置元素交换；
     * 时间复杂度为o(n*n)
     *
     */
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
    // 堆排序
    public static void heapSort(int[] array) {

        int size = array.length - 1;
        MaxHeap.build(array, size);
        while (size > 1) {
            swapPos(array, 1, size);
            size--;
            MaxHeap.adjust(1, size, array);
        }
    }
    public static void swapPos(int[] array, int pos1, int pos2) {
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }


/**
 * 将待排序序列分为两部分，有序序列和无需序列，
 * 每次从无序序列中去一个元素，与有序序列中元素比较大小，并插入到相应位置
 *
 * 时间复杂度为o(n*n)，对有序序列的时间复杂度为o(n)
 */

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

    // 希尔排序
    public static void shellSort(int[] array, int[] sedhewick, int maxSedgewick) {

        int i = 0;
        for (; sedhewick[i] > maxSedgewick; i++) { }

        for (int j = array.length / 2; j > 0; j /= 2) {
            for (int k = 0; k < j; k++) {
                for (int l = k + j; l < array.length; l += j) {
                    for (int m = l; m - j >= 0; m -= j) {
                        if (array[m] < array[m - j]) {
                            swapPos(array, m - j, m);
                            //break;
                        }
                    }
                }
            }
        }
    }
    /**
     * 冒泡排序
     * @param array
     */
    public static void bubbleSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    Sort.swapPos(array, i, j);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {34,56,78,23,7,4,6,278,234,91,3, 2,4,6,9,0};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        simpleInsertionSort(arr);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //快速排序
    public static void quickSort(int[] array, int left, int right, int threshold) {

        if ((right - left) <= 1 || (right - left) <= threshold) {
            简单插入排序.simpleInsertionSort(array, left, right);
        } else { //数据量足够快速排序
            int low = left;
            int heigh = right;
            int benchmark = getBenchmark(array, low, heigh);
            heigh--;
            while (true) {
                while (array[++low] < benchmark);
                while (array[--heigh] > benchmark);
                if (low < heigh) {
                    swapPos(array, low, heigh);
                } else {
                    break;
                }
            }
            swapPos(array, low, right - 1);
            quickSort(array, left, low - 1, threshold); // 排左边
            quickSort(array, low + 1, right, threshold); //排右边
        }
    }

    public static int getBenchmark(int[] array, int low, int heigh) {
        int mid = (low + heigh) / 2;
        if (array[low] > array[mid]) {
            swapPos(array, low, mid);
        }
        if (array[low] > array[heigh]) {
            swapPos(array, low, heigh);
        }
        if (array[mid] > array[heigh]) {
            swapPos(array, mid, heigh);
        }
        swapPos(array, mid, heigh - 1);

        return array[heigh - 1];

    }
}
