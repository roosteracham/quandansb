package 刷题.腾讯;

import java.util.*;

/**
 * <p>  小Q的公司最近接到m个任务, 第i个任务需要xi的时间去完成, 难度等级为yi。<br>
 *     小Q拥有n台机器, 每台机器最长工作时间zi, 机器等级wi。<br>
 *         对于一个任务,它只能交由一台机器来完成, 如果安排给它的机器的最长工作时间小于任务需要的时间,
 * 则不能完成,如果完成这个任务将获得200 * xi + 3 * yi收益。 </p>
 * <p>  对于一台机器,它一天只能完成一个任务, 如果它的机器等级小于安排给它的任务难度等级, 则不能完成。 </p>
 * <p>  小Q想在今天尽可能的去完成任务, 即完成的任务数量最大。如果有多种安排方案,小Q还想找到收益最大的那个方案。小Q需要你来帮助他计算一下。 </p>
 * <pre>输入包括N + M + 1行,<br>输入的第一行为两个正整数n和m(1 &lt;= n, m &lt;= 100000), 表示机器的数量和任务的数量。<br>接下来n行,每行两个整数xi和yi(0 &lt; xi &lt; 1000, 0 &lt;= yi &lt;= 100), 表示每台机器的最大工作时间和机器等级。<br>接下来的m行,每行两个整数zi和wi(0 &lt; zi &lt; 1000, 0 &lt;= wi &lt;= 100), 表示每个任务需要的完成时间和任务的难度等级wi。</pre>
 *
 * <pre>输出两个整数, 分别表示最大能完成的任务数量和获取的收益。</pre>
 */
public class 安排机器 {

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Com[] coms = new Com[n + m];
        //Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            coms[i] = new Com(a,b);
            //map.put(a, b);
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b= scanner.nextInt();
            coms[i + n] = new Com(a,b);
            //map.put(a, b);
        }
        Arrays.sort(coms);

           /*Com[] coms = new Com[3];
           coms[0] = new Com(3,4);
        coms[1] = new Com(1,3);
        coms[2] = new Com(3,2);
        for (int i = 0; i < coms.length; i++) {
            System.out.println(coms[i].time + " " + coms[i].level);
        }
*/
        Arrays.sort(coms, new Comparator<Com>() {
            @Override
            public int compare(Com o1, Com o2) {
               /* Com com1 = o1;
                Com com2 = o1;*/
                if (o1.level > o2.level ) {
                    return 2;
                } else if (o1.level < o2.level && o1.time < o2.time){
                    return -1;
                } else if (o1.time > o2.time) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < coms.length; i++) {
            System.out.println(coms[i].time + " " + coms[i].level);
        }
    }
}

class Com {

    public Com(int time, int level) {
        this.time = time;
        this.level = level;
    }

    public int time;
    public int level;
    /*public int compare(Object o1, Object o2) {
        Com com1 = (Com)o1;
        Com com2 = (Com)o1;
        if (com1.level > com2.level) {
            return 2;
        } else if (com1.level < com2.level){
            return -1;
        } else if (com1.time > com2.time) {
            return 1;
        } else if (com1.time < com2.time) {
            return -2;
        }
        else {
            return 0;
        }
    }*/
}