package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Boj9461 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        int testCase = Integer.parseInt(br.readLine());
        long[] spiral = new long[101];
        spiral[1] = spiral[2] = spiral[3] = 1;
        spiral[4] = spiral[5] = 2;

        for (int i = 6; i < 101; i++) {
            spiral[i] = spiral[i - 1] + spiral[i - 5];
        }

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(spiral[n]);
        }
    }
}
