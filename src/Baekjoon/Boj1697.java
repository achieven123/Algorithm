package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1697 {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] visit = new int[200001];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        visit[n] = 0;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num == k) {
                System.out.println(visit[num]);
                break;
            }

            if (num - 1 >= 0) {
                if (visit[num - 1] == 0) {
                    visit[num - 1] = visit[num] + 1;
                    queue.add(num - 1);
                }
            }

            if (num + 1 < 200001) {
                if (visit[num + 1] == 0) {
                    visit[num + 1] = visit[num] + 1;
                    queue.add(num + 1);
                }
            }

            if (num * 2 < 200001) {
                if (visit[num * 2] == 0) {
                    visit[num * 2] = visit[num] + 1;
                    queue.add(num * 2);
                }
            }
        }
    }
}
