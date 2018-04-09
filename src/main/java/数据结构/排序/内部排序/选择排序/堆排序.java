package 数据结构.排序.内部排序.选择排序;

import 数据结构.binarytree.堆.Heap;
import 数据结构.binarytree.堆.MaxHeap;

public class 堆排序 {

    public static void heapSort(int[] array) {

        int size = array.length - 1;
        MaxHeap.build(array, size);
        while (size > 1) {
            Heap.swapPos(array, 1, size);
            size--;
            MaxHeap.adjust(1, size, array);
        }
    }

    public static void main(String[] args) {
        int[] array = {0,2,3,4,5,6,7,8,9,1,42};

        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
        heapSort(array);
        System.out.println();
        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
