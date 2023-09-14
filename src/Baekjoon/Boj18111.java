package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Boj18111 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        int N, M, B;
        int time = 0, height = 0;
        int sum = 0, min = 256, max = 256;
        int[][] array;
        String[] input;

        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        B = Integer.parseInt(input[2]);

        array = new int[N][];
        for (int i = 0; i < array.length; i++) array[i] = new int[M];

        for (int y = 0; y < N; y++) {
            input = br.readLine().split(" ");

            for (int x = 0; x < M; x++) {
                array[y][x] = Integer.parseInt(input[x]);
                sum += array[y][x];
                if (array[y][x] < min) min = array[y][x];
            }
        }

        max = Math.min(max, (sum + B) / (N * M));

        for (int i = min; i <= max; i++) {
            int tempTime = 0;

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    int difference = array[y][x] - i;

                    if (difference > 0) tempTime += 2 * difference;
                    else if (difference < 0)  tempTime -= difference;
                }
            }

            if (i == min) {
                time = tempTime;
                height = i;
            } else {
                if (tempTime <= time) {
                    time = tempTime;
                    height = i;
                }
            }
        }

        System.out.print(time + " " + height);
    }
}
