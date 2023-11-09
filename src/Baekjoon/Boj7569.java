package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7569 {

    static int m, n, h;
    static int[][][] tomato;
    static int[][][] visit;

    static Queue<Integer> queueY = new LinkedList<>();
    static Queue<Integer> queueX = new LinkedList<>();
    static Queue<Integer> queueZ = new LinkedList<>();

    static void bfs() {
        int[] dz = { -1, 1, 0, 0, 0, 0 };
        int[] dy = { 0, 0, -1, 1, 0, 0 };
        int[] dx = { 0, 0, 0, 0, -1, 1 };

        while (!queueY.isEmpty()) {
            int peekZ = queueZ.remove();
            int peekY = queueY.remove();
            int peekX = queueX.remove();

            for (int i = 0; i < 6; i++) {
                int z = peekZ + dz[i];
                int y = peekY + dy[i];
                int x = peekX + dx[i];

                if (z >= 0 && z < h && y >= 0 && y < n && x >= 0 && x < m) {
                    if (tomato[z][y][x] == 0) {
                        tomato[z][y][x] = tomato[peekZ][peekY][peekX] + 1;

                        queueZ.add(z);
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
        h = Integer.parseInt(st.nextToken());

        tomato = new int[h][n][m];
        visit = new int[h][n][m];

        for (int i = 0; i < h; i++) {

            for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());

                    if (tomato[i][j][k] == 1) {
                        queueZ.offer(i);
                        queueY.offer(j);
                        queueX.offer(k);
                    }
                }
            }
        }

        bfs();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomato[i][j][k] > day) day = tomato[i][j][k];
                    if (tomato[i][j][k] == 0) flag = true;
                    if (tomato[i][j][k] == 1) count++;
                }
            }
        }

        if (flag == true) System.out.println(-1);
        else if (count == n * m) System.out.println(0);
        else System.out.println(day - 1);
    }
}
