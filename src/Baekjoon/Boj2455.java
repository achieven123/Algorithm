package Baekjoon;

import java.util.Scanner;

public class Boj2455 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int people = 0;
        int max = 0;
        int in = 0;
        int out = 0;

        for (int i = 0; i < 4; i++) {
            out = scan.nextInt();
            in = scan.nextInt();
            people += in - out;

            if (people > max) {
                max = people;
            }
        }

        System.out.println(max);
    }
}
