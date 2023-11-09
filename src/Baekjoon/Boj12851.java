package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj12851 {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] visit = new int[200001];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        queue.add(n);

        while (!queue.isEmpty()) {
            System.out.println(queue);

            int num = queue.poll();

            if (num > 0 || num <= k + 1 || num * 2 <= k + 1) {

            }

            if (num - 1 >= 0) {
                if (visit[num - 1] == 0) {
                    visit[num - 1] = visit[num] + 1;
                    queue.add(num - 1);
                }
//                if (num - 1 == k) {
//                    if (visit[num - 1] == visit[num] + 1) count++;
//                    queue.add(num - 1);
//                    System.out.println(num - 1);
//                }
            }

             if (num <= k + 1) {
                if (visit[num + 1] == 0) {
                    visit[num + 1] = visit[num] + 1;
                    queue.add(num + 1);
                }
//
//                if (num + 1 == k) {
//                    if (visit[num + 1] == visit[num] + 1) count++;
//                    queue.add(num + 1);
//                    System.out.println(num + 1);
//                }
            }

            if (num * 2 < k + 1) {
                if (visit[num * 2] == 0) {
                    visit[num * 2] = visit[num] + 1;
                    queue.add(num * 2);
                }

//                if (num * 2 == k) {
//                    if (visit[num * 2] == visit[num] + 1) count++;
//                    queue.add(num * 2);
//                    System.out.println(num * 2);
//                }
            }

        }

        System.out.println(visit[k]);
        System.out.println(count);

    }
}
