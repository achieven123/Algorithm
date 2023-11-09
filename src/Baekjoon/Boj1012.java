package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1012 {

    static int m, n, k, x, y;
    static int[][] input;

    static Queue<int[]> queue = new LinkedList<>();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void bfs(int y, int x) {
        queue.add(new int[]{y, x});
        input[y][x] = 0;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int peekY = arr[0];
            int peekX = arr[1];

            for (int i = 0; i < 4; i++) {
                int ny = peekY + dy[i];
                int nx = peekX + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (input[ny][nx] == 1) {
                        input[ny][nx] = 0;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            int count = 0;

            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            input = new int[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());

                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                input[y][x] = 1;
            }

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (input[j][l] == 1) {
                        bfs(j, l);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
