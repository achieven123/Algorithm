package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Boj2579 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][n];

        int score = Integer.parseInt(br.readLine());
        arr[0][0] = arr[1][0] = score;

        for (int i = 1; i < n; i++) {
            score = Integer.parseInt(br.readLine());
            if (i == 1) {
                arr[0][1] = score + arr[1][0];
                arr[1][1] = score;
            } else {
                arr[0][i] = score + arr[1][i - 1];
                if (arr[0][i - 2] > arr[1][i - 2]) {
                    arr[1][i] = score + arr[0][i - 2];
                } else {
                    arr[1][i] = score + arr[1][i - 2];
                }
            }
        }

        int ans = Math.max(arr[0][n - 1], arr[1][n - 1]);
        System.out.println(ans);
    }

}
