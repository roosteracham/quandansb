package 刷题.wangyi;

import java.util.Scanner;

public class 调整队形 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String temp = line;
        int timeGb = 0;
        while (true) {
            if (temp.contains("BG")) {
                temp = temp.replaceFirst("BG", "GB");
                timeGb++;
            } else {
                break;
            }
        }

        int timeBG = 0;
        temp = line;
        while (true) {
            if (temp.contains("GB")) {
                temp = temp.replaceFirst("GB", "BG");
                timeBG++;
            } else {
                break;
            }
        }

        System.out.println(Math.min(timeBG, timeGb));
    }
}
