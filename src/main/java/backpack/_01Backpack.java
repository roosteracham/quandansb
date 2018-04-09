package backpack;

import java.util.Scanner;

public class _01Backpack {

    public static void main(String[] args) {

        pack1();

    }

    public void pack2() {

        int pack =5, v = 10;
        int[] weight = {1, 2, 3, 4, 5};
        int[] value = {3,5,7,9,2};
        int[][] f = new int[pack][v];
        for (int i = 0; i< pack; i++) {
            f[i][0] = 0;
        }

        for (int i = 0; i < f[1][i] ; i++) {
            f[1][i] = i < weight[0] ? 0 : value[0];
        }
    }

    public static void pack1() {
        int nCases;
        int nPack, nMaxVolume;

        Scanner scanner = new Scanner(System.in);

        //freopen("input.txt", "r", stdin);
        nCases = scanner.nextInt();

        while(nCases-- != 0)
        {

            nPack = scanner.nextInt();

            nMaxVolume = scanner.nextInt();
            int weight[] =new int[nPack]; int value[] = new int[nPack];
            int record[] = new int[2000];
            //memset(record, 0, sizeof(record));
            // nPack 骨头的数量，nMaxVolume 箱子最大体积

            for(int x=0; x<nPack; ++x)
                value[x] = scanner.nextInt();

            for(int k=0; k<nPack; ++k)
                weight[k] = scanner.nextInt();

            for(int i=0; i<nPack; ++i)
                for(int j=nMaxVolume; j>=weight[i]; --j)
                {
                    if(record[j-weight[i]]+value[i] > record[j])
                        record[j] = record[j-weight[i]]+value[i];
                    System.out.println(i + " " + j + " " + record[j]);
                }

            System.out.println(record[nMaxVolume]);
        }
    }
}