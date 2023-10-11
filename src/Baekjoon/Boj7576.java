package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576 {

    static int m, n;
    static int[][] tomato;
    static int[][] visit;

    static Queue<Integer> queueY = new LinkedList<>();
    static Queue<Integer> queueX = new LinkedList<>();

    static void bfs() {
        int[] dy = { -1, 1, 0, 0 };
        int[] dx = { 0, 0, -1, 1 };

        while (!queueY.isEmpty()) {
            int peekY = queueY.remove();
            int peekX = queueX.remove();

            for (int i = 0; i < 4; i++) {
                int y = peekY + dy[i];
                int x = peekX + dx[i];

                if (y >= 0 && y < n && x >= 0 && x < m) {
                    if (tomato[y][x] == 0) {
                        tomato[y][x] = tomato[peekY][peekX] + 1;

                        queueY.add(y);
                        queueX.add(x);
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

        int day = 0;
        int count = 0;
        boolean flag = false;

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        tomato = new int[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());

                if (tomato[i][j] == 1) {
                    queueY.offer(i);
                    queueX.offer(j);
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] > day) day = tomato[i][j];
                if (tomato[i][j] == 0) flag = true;
                if (tomato[i][j] == 1) count++;
            }
        }
        if (flag == true) System.out.println(-1);
        else if (count == n * m) System.out.println(0);
        else System.out.println(day - 1);
    }
}
