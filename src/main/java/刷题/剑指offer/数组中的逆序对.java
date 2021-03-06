package 刷题.剑指offer;

/**
 * 题目描述
 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 即输出P%1000000007
 输入描述:
 题目保证输入的数组中没有的相同的数字

 数据范围：

 对于%50的数据,size<=10^4

 对于%75的数据,size<=10^5

 对于%100的数据,size<=2*10^5

 示例1
 输入
 1,2,3,4,5,6,7,0
 输出
 7
 */
public class 数组中的逆序对 {
    public int InversePairs(int[] array) {

        long sum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {

                if (array[i] > array[j]) {
                    sum += 1;
                }
            }
        }
        return (int) (sum % 1000000007);
    }
}
