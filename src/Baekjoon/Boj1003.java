package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1003 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());
        int[][] arrNum = new int[41][2];

        arrNum[0][0] = 1; arrNum[0][1] = 0;
        arrNum[1][0] = 0; arrNum[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            arrNum[i][0] = arrNum[i - 1][0] + arrNum[i - 2][0];
            arrNum[i][1] = arrNum[i - 1][1] + arrNum[i - 2][1];
        }

        for (int i = 0; i < testCase; i++) {
            int num = Integer.parseInt(br.readLine());

            System.out.println(arrNum[num][0] + " " + arrNum[num][1]);
        }
    }
}
