package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2606 {

    static int dfs(ArrayList<Integer>[] graph, int n, int v) {
        Stack<Integer> stack = new Stack<>();
        int[] visit = new int[n + 1];
        int count = 0;

        stack.push(v);
        visit[v] = 1;

        while (!stack.isEmpty()) {
            int vertex1 = stack.peek();
            int length = graph[vertex1].size();
            boolean flag = true;

            for (int i = 0; i < length; i++) {
                int vertex2 = graph[vertex1].get(i);

                if (visit[vertex2] == 0) {
                    count++;
                    stack.push(vertex2);
                    visit[vertex2] = 1;
                    flag = false;
                    break;
                }
            }

            if (flag) {
                stack.pop();
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st;

        int n, m, ans;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            graph[vertex1].add(vertex2);
            graph[vertex2].add(vertex1);
        }

        for (int i = 0; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        ans = dfs(graph, n, 1);

        System.out.println(ans);
    }
}
