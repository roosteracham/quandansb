package 刷题.wangyi;

import 刷题.今日头条.BinarySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 牛牛找工作 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] num = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            num[i] = a;
            if (map.containsKey(a)) {
                int c = map.get(a);
                c = c > b ? c : b;
            } else  {
                map.put(a, b);
            }
        }

        insertSort(num);

        int[] result = new int[M];
        for (int k = 0; k < M; k++) {
            int ability = scanner.nextInt();
            if (ability < num[0]) {
                result[k] = 0;
                continue;
            }
            if (ability == num[num.length - 1]) {

                result[k] = map.get(ability);
                continue;
            }
            int pos = BinarySearch.lastMaxPosOfLessThanValue(num, ability, 0, num.length - 1);

            result[k] = (map.get(num[pos]));
        }

        for (int i = 0; i < M; i++) {
            System.out.println(result[i]);
        }
    }

    public static void shellSortSmallToBig(int[] data) {
        int j = 0;
        int temp = 0;
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            System.out.println("increment:" + increment);
            for (int i = increment; i < data.length; i++) {
                // System.out.println("i:" + i);
                temp = data[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    // System.out.println("j:" + j);
                    // System.out.println("temp:" + temp);
                    // System.out.println("data[" + j + "]:" + data[j]);
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp;
            }/*
            for (int i = 0; i < data.length; i++)
                System.out.print(data[i] + " ");*/
        }
    }

    public static void insertSort(int[] a) {
        int i, j, insertNote;// 要插入的数据
        for (i = 1; i < a.length; i++) {// 从数组的第二个元素开始循环将数组中的元素插入
            insertNote = a[i];// 设置数组中的第2个元素为第一次循环要插入的数据
            j = i - 1;
            while (j >= 0 && insertNote < a[j]) {
                a[j + 1] = a[j];// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                j--;
            }
            a[j + 1] = insertNote;// 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
        }
    }

    /**
     * <pre>
     3 3
     1 100
     10 1000
     1000000000 1001
     9 10 1000000000</pre>
     * @param array
     * @param val
     * @return
     */


}
