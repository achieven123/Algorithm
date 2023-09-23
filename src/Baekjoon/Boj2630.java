package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2630 {

    static int white = 0;
    static int blue = 0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        paper = new int[length][length];

        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < length; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cuttingPaper(length, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void cuttingPaper(int length, int row, int col) {
        int count = 0;

        for (int y = row; y < row + length; y++) {
            for (int x = col; x < col + length; x++) {
                if (paper[y][x] == 1) count++;
            }
        }

        if (count != length * length && count != 0) {
            length = length / 2;
            cuttingPaper(length, row, col);
            cuttingPaper(length, row, col + length);
            cuttingPaper(length, row + length, col);
            cuttingPaper(length, row + length, col + length);
        } else {
            if (count == 0) white++;
            else blue++;
        }
    }
}
