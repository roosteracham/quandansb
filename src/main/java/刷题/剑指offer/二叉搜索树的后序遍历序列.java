package 刷题.剑指offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

 */
public class 二叉搜索树的后序遍历序列 {

    /**
     * BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，
     * 那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，
     * 且这两段（子树）都是合法的后序序列。完美的递归定义 : ) 。
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST(int [] sequence) {

        if (sequence.length == 0) {
            return true;
        }
        if (sequence.length == 1) {
            return true;
        }
        int i = 0;
        for (; i < sequence.length; i++) {
            if (sequence[i] > sequence[sequence.length - 1]){
                break;
            }
        }
        for (int j = i; j < sequence.length - 1; j++) {
            if (sequence[j] < sequence[sequence.length - 1]) {
                return false;
            }
        }
        return VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i)) &&
                VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length - 1));
    }

    public static void main(String[] args) {
        int[] a = {4,8,6,12,16,14,10};
        System.out.println(VerifySquenceOfBST(a));
    }
}
