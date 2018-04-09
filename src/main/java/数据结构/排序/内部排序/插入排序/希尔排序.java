package 数据结构.排序.内部排序.插入排序;

public class 希尔排序 {
    
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
        int[] wick = {929, 505, 209, 109, 41, 19, 5, 1, 0};
        shellSort(arr, wick,5);
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
