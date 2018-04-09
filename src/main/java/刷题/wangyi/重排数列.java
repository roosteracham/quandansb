package 刷题.wangyi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
 牛博士给小易出了一个难题:
 对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
 小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
 输入描述:
 输入的第一行为数列的个数t(1 ≤ t ≤ 10),
 接下来每两行描述一个数列A,第一行为数列长度n(1 ≤ n ≤ 10^5)
 第二行为n个正整数A[i](1 ≤ A[i] ≤ 10^9)


 输出描述:
 对于每个数列输出一行表示是否可以满足牛博士要求,如果可以输出Yes,否则输出No。

 输入例子1:
 2
 3
 1 10 100
 4
 1 2 3 4

 输出例子1:
 Yes
 No
 */
public class 重排数列 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        List<String> result = new LinkedList<>();
        for (int i = 0; i < a; i++) {
            int mod4 = 0;
            int _not2_4 = 0;
            int _2not_4 = 0;
            int num = scanner.nextInt();
            int[] nums = StringUtil.getInputNumber(num, scanner);
            for (int j = 0, k = nums.length - 1; k - j >= 1; j++, k--) {
                if ((nums[j]) % 4 == 0) {
                    mod4++;
                } else if (nums[j] % 4 != 0 && nums[j] % 2 != 0) {
                    _not2_4++;
                }

                if ((nums[k]) % 4 == 0) {
                    mod4++;
                } else if (nums[k] % 4 != 0 && nums[k] % 2 != 0) {
                    _not2_4++;
                }

                if (k - j == 2) {
                    if ((nums[--k]) % 4 == 0) {
                        mod4++;
                    } else if (nums[--k] % 4 != 0 && nums[--k] % 2 != 0) {
                        _not2_4++;
                    }
                    break;
                }
            }

            if (mod4 >= _not2_4) {
                result.add("Yes");
            } else if(_not2_4 - mod4 > 1){
                result.add("No");
            } else if (_not2_4 - mod4 == 1 && _2not_4 == 0) {

                result.add("Yes");
            }else {

                result.add("No");
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

        //System.out.print(result.get(result.size() - 1));
    }
}