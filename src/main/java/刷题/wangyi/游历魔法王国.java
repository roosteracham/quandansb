package 刷题.wangyi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 魔法王国一共有n个城市,编号为0~n-1号,n个城市之间的道路连接起来恰好构成一棵树。
 小易现在在0号城市,每次行动小易会从当前所在的城市走到与其相邻的一个城市,小易最多能行动L次。
 如果小易到达过某个城市就视为小易游历过这个城市了,小易现在要制定好的旅游计划使他能游历最多的城市,
 请你帮他计算一下他最多能游历过多少个城市(注意0号城市已经游历了,游历过的城市不重复计算)。
 输入描述:
 输入包括两行,第一行包括两个正整数n(2 ≤ n ≤ 50)和L(1 ≤ L ≤ 100),表示城市个数和小易能行动的次数。
 第二行包括n-1个整数parent[i](0 ≤ parent[i] ≤ i), 对于每个合法的i(0 ≤ i ≤ n - 2),在(i+1)号城市和parent[i]间有一条道路连接。


 输出描述:
 输出一个整数,表示小易最多能游历的城市数量。

 输入例子1:
 5 2
 0 1 2 3

 输出例子1:
 3
 */
public class 游历魔法王国 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        City[] cities = new City[num];

        int step = scanner.nextInt();

        for (int i = 0; i < num; i++) {
            cities[i] = new City(i);
        }

        //int city0 = scanner.nextInt();
        for (int i = 0; i < num - 1; i++) {
            int n = scanner.nextInt();
            cities[n].to.add(cities[i + 1]);
        }

        int height = 1;
        List<City> queue = new LinkedList<>();
        queue.add(cities[0]);
        while (!queue.isEmpty()) {
            City city = queue.get(queue.size() - 1);
            if (!city.visited) {
                city.visited = true;
                height++;
                if (city.to.isEmpty()) {
                    queue.remove(city);
                } else {
                    queue.add(0, city.to.get(0));
                }
            }

            if (--step == 0) {
                break;
            }
        }
    }

}

class City {
    public int id;
    public List<City> to = new ArrayList<>();

    public boolean visited = false;

    public City(int id) {
        this.id = id;
    }

    public City() {
    }
}