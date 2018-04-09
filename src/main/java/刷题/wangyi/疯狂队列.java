package 刷题.wangyi;

/**
 * 小易老师是非常严厉的,它会要求所有学生在进入教室前都排成一列,并且他要求学生按照身高不递减的顺序排列。
 * 有一次,n个学生在列队的时候,小易老师正好去卫生间了。学生们终于有机会反击了,于是学生们决定来一次疯狂的队列,
 * 他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。由于按照身高顺序排列的队列的疯狂值是最小的,
 * 他们当然决定按照疯狂值最大的顺序来进行列队。现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值。
 * 小易老师回来一定会气得半死。
 输入描述:
 输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),表示学生的人数
 第二行为n个整数h[i](1 ≤ h[i] ≤ 1000),表示每个学生的身高


 输出描述:
 输出一个整数,表示n个学生列队可以获得的最大的疯狂值。

 如样例所示:
 当队列排列顺序是: 25-10-40-5-25, 身高差绝对值的总和为15+30+35+20=100。
 这是最大的疯狂值了。

 输入例子1:
 5
 5 10 25 40 25

 输出例子1:
 100
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 疯狂队列 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<Integer> list = StringUtil.inputNumberToList(num, scanner, new ArrayList());

        Collections.sort(list);

        //List<Integer> queue = new LinkedList<>();
        int[] queue = new int[num];
        int sum = 0, mid = (num - 1)/ 2;
        int a = 1, b = -1;
        boolean change = true;
        queue[mid] = (list.remove(--num));
        int time = 0;
        while (list.size() != 1) {
            if (change) {//先去小的

                if (time == 0 && list.get(0) != null) {
                    queue[mid + a++] = list.get(0);
                    list.remove(0);
                    time++;
                } else if (time == 1 && list.get(0) != null) {
                    queue[mid + b--] = list.get(0);
                    list.remove(0);
                    time++;
                    if (time == 2) {
                        change = false;
                        time = 0;
                    }
                }
            } else {
                if (time == 0 && list.get(num - 1) != null) {
                    queue[mid + a++] = list.get(num - 1);
                    list.remove(num - 1);
                    time++;
                } else if (time == 1 && list.get(num - 1) != null) {
                    queue[mid + b--] = list.get(num - 1);
                    list.remove(num - 1);
                    time++;
                    if (time == 2) {
                        change = true;
                        time = 0;
                    }
                }
            }
            num--;
        }

        for (int i = 0; i < queue.length - 1; i++) {
            sum += Math.abs(queue[i] - queue[i + 1]);
        }
        int t = 0;
        if (list.size() == 1) {
            int last = list.remove(--num);

            t = Math.abs(last - queue[mid + --a]) > Math.abs(last - queue[mid + ++b]) ?
                    Math.abs(last - queue[mid + a]) : Math.abs(last - queue[mid + b]);
        }
        if (queue[0] == 0) {
            sum = sum + t - queue[1];
        } else {
            sum += t - queue[queue.length - 2];
        }
        System.out.println(sum);
    }
}
