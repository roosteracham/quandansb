package 数据结构.binarytree;

import java.util.Arrays;

/**
 * ���ֲ���
 * @author gpp
 *
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {2,3,34,34,23,12,45,576,67,7};
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
            System.out.print(binarySearch(a, 56));
    }
    public static int binarySearch(int[] bs, int key) {
        if(key < 0 || key > bs.length -1)
            return -1;
        int left = 0, right = bs.length - 1, middle;
        while(left < right) {
            middle = (left + right) / 2;
            if(middle > key) {
                right = middle;
            }else if(middle < key){
                left = middle;
            }else{
                return middle;
            }
        }
        return -1;
    }
}
