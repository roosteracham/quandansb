package 刷题.今日头条;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 手串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        int m = scanner.nextInt();
        int color = scanner.nextInt();
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < line; i++) {
            int colors = scanner.nextInt();
            for (int j = 0; j < colors; j++) {
                int num_color = scanner.nextInt();
                int[] lines;
                if (!map.containsKey(num_color)) {
                    lines = new int[line + m];
                } else {
                    lines = map.get(num_color);
                }
                lines[i] = 1;
                map.put(num_color, lines);
            }
        }
        int result = 0;
        for (int i = 1; i < color + 1; i++) {
            int[] lines = map.get(i);
            for (int first = 0; first < m; first++) {
                lines[line + first] = lines[first];
            }
            boolean flag = false;
            for (int j = 0; j < lines.length - m; j++) {
                int a = 0;
                for (int v = j; v < j + m; v++) {
                    if (lines[v] == 1) {
                        a++;
                    }
                    if (a == 2) {
                        flag = true;
                        result++;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            /*for (int k = line - m; k < line; k++) {
                int b = 0,
                        left = k - line + m;
                for (int ll = k; ll < line; ll ++) {
                    if (lines[ll] == 1) {
                        b++;
                    }
                    if (b >= 2) {
                        result++;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
                for (int l = 0; l < left; l++) {
                    if (lines[l] == 1) {
                        b++;
                    }
                    if (b >= 2) {
                        result++;
                        break;
                    }
                }
            }*/
        }
        System.out.println(result);
    }
}
