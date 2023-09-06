package Baekjoon;

import java.util.Scanner;

public class Boj9095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int[] arrSum  = new int[11];

        arrSum[1] = 1;
        arrSum[2] = 2;
        arrSum[3] = 4;

        for (int j = 4; j <= 10; j++) {
            arrSum[j] = arrSum[j - 3] + arrSum[j - 2] + arrSum[j - 1];
        }

        for (int i = 0; i < testCase; i++) {
            int num = sc.nextInt();
            System.out.println(arrSum[num]);
        }
    }
}
