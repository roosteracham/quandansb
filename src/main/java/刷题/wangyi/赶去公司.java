package 刷题.wangyi;

import java.util.Scanner;

/**
 * 终于到周末啦！小易走在市区的街道上准备找朋友聚会，突然服务器发来警报,小易需要立即回公司修复这个紧急bug。
 * 假设市区是一个无限大的区域，每条街道假设坐标是(X，Y)，小易当前在(0，0)街道，办公室在(gx,gy)街道上。
 * 小易周围有多个出租车打车点，小易赶去办公室有两种选择，一种就是走路去公司，另外一种就是走到一个出租车打车点，
 * 然后从打车点的位置坐出租车去公司。每次移动到相邻的街道(横向或者纵向)走路将会花费walkTime时间，
 * 打车将花费taxiTime时间。小易需要尽快赶到公司去，现在小易想知道他最快需要花费多少时间去公司。
 */
public class 赶去公司 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();scanner.nextLine();

        int[] tX = StringUtil.stringToInts(scanner.nextLine(), " ");
        int[] tY = StringUtil.stringToInts(scanner.nextLine(), " ");

        int[] g = StringUtil.stringToInts(scanner.nextLine(), " ");
        int gX = g[0], gY = g[1];


        int[] time = StringUtil.stringToInts(scanner.nextLine(), " ");
        int wT = time[0], tT = time[1];

        int wTotal = (Math.abs(gX) + Math.abs(gY)) * wT;

        int i = 0, xy = 0;
        int tTotal = 0;
        for (; i < n; i++) {

            xy = Math.abs(tX[i]) + Math.abs(tY[i]);
            tTotal = wT * xy + tT * (Math.abs(gX - tX[i]) + Math.abs(gY - tY[i]));

            if (wTotal > tTotal) {
                wTotal = tTotal;
            }
        }

        System.out.println(wTotal);
    }
}
