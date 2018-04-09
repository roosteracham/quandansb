package 数据结构.排序.内部排序.交换排序;

import 数据结构.排序.内部排序.插入排序.简单插入排序;

public class 快速排序 {

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
        quickSort(arr, 0,arr.length - 1, 0);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        简单插入排序.simpleInsertionSort(arr, 0,arr.length - 1);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
