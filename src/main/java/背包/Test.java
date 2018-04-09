package 背包;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Test {
    private static Set<Virtual> virtuals = new HashSet<>();
    private static Set<Physical> physicals = new HashSet<>();
    private static int pCpu;
    private static int pMem;
    //true:cpu;false:mem
    private static boolean cpuOrMem;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        pCpu = scanner.nextInt();
        pMem = scanner.nextInt();
        int vSort = scanner.nextInt();
        for (int i = 0; i < vSort; i++) {
            String vName = scanner.next();
            int vCpu = scanner.nextInt();
            int vMem = scanner.nextInt();
            int vNum = scanner.nextInt();
            virtuals.add(new Virtual(vName, vCpu, vMem, vNum));
        }
        cpuOrMem = scanner.next().equals("CPU");
        solution();

        physicals.forEach(physical -> {
            System.out.println(physical.toString());
        });
    }

    private static void solution() {
        while (remains()) {
            physicals.add(beibao());
        }
    }

    private static Physical beibao() {
        Physical physical = new Physical(pCpu, pMem);
        int dp[][][] = new int[virtuals.size() + 1][pCpu + 1][pMem + 1];
        Virtual dpV[][][] = new Virtual[virtuals.size() + 1][pCpu + 1][pMem + 1];
        int v = 1;
        Iterator<Virtual> iterator = virtuals.iterator();
        while (iterator.hasNext()) {
            Virtual virtual = iterator.next();
            for (int i = 0; i <= pCpu; i++) {
                for (int j = 0; j <= pMem; j++) {
                    int vNum = 0;
                    int maxVNum = Math.min(virtual.getNum(), i / virtual.getCpu());
                    maxVNum = Math.min(maxVNum, j / virtual.getMem());
                    for (int k = 0; k <= maxVNum; k++) {
                        int newVal = dp[v - 1][i - k * virtual.getCpu()][j - k * virtual.getMem()]
                                + k * virtual.getValue(cpuOrMem);
                        if (newVal > dp[v][i][j]) {
                            dp[v][i][j] = newVal;
                            vNum = k;
                        }
                    }
                    dpV[v][i][j] = new Virtual(virtual.getName(), virtual.getCpu(), virtual.getMem(), vNum);
                    dpV[v][i][j].setPre(dpV[v - 1][i - vNum * virtual.getCpu()][j - vNum * virtual.getMem()]);
                }
            }
            v++;
        }

        Virtual pre = dpV[virtuals.size()][pCpu][pMem];
        while (pre != null) {
            if (!pre.isEmpty()) {
                physical.add(pre);
                minus(virtuals, pre);
            }
            pre = pre.getPre();
        }
        return physical;
    }

    private static boolean remains() {
        Iterator<Virtual> iterator = virtuals.iterator();
        while (iterator.hasNext()) {
            Virtual virtual = iterator.next();
            if (virtual.isEmpty()) iterator.remove();
        }
        return virtuals.size() != 0;
    }

    private static void minus(Set<Virtual> virtuals, Virtual v) {
        virtuals.forEach(virtual -> {
            if (virtual.equals(v))
                virtual.minus(v.getNum());
        });
    }
}
