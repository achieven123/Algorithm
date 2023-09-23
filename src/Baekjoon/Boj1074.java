package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1074 {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        visitIndex((int) Math.pow(2, N), r, c);

        System.out.println(count);
    }

    static void visitIndex(int N, int r, int c) {
        if (N == 1) return;
        N = N / 2;

        if (r < N && c < N) {
            visitIndex(N, r, c);
        } else if (r < N && c >= N) {
            count += N * N;
            visitIndex(N, r, c - N);
        } else if (r >= N && c < N) {
            count += N * N * 2;
            visitIndex(N, r - N, c);
        } else if (r >= N && c >= N) {
            count += N * N * 3;
            visitIndex(N, r - N, c - N);
        }
    }
}
