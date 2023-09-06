package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Boj11399 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfPeople = sc.nextInt();
        int[] arrInt = new int[numOfPeople];
        int sum = 0;

        for (int idx = 0; idx < numOfPeople; idx++) {
            arrInt[idx] = sc.nextInt();
        }

        Arrays.sort(arrInt);

        for (int idx = 0; idx < numOfPeople; idx++) {
            for (int i = 0; i <= idx; i++) {
                sum += arrInt[i];
            }
        }

        System.out.println(sum);
    }
}
