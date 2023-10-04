package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1260 {

    static void dfs(ArrayList<Integer>[] graph, int n, int v) {
        Stack<Integer> stack = new Stack<>();
        int[] visit = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        stack.push(v);
        visit[v] = 1;
        sb.append(v + " ");

        while (!stack.isEmpty()) {
            int vertex1 = stack.peek();
            int length = graph[vertex1].size();
            boolean flag = true;

            for (int i = 0; i < length; i++) {
                int vertex2 = graph[vertex1].get(i);

                if (visit[vertex2] == 0) {
                    sb.append(vertex2 + " ");
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

        System.out.println(sb);
    }

    static void bfs(ArrayList<Integer>[] graph, int n, int v) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visit = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        queue.add(v);
        visit[v] = 1;

        while (!queue.isEmpty()) {
            int vertex1 = queue.peek();
            int length = graph[vertex1].size();
            boolean flag = true;

            for (int i = 0; i < length; i++) {
                int vertex2 = graph[vertex1].get(i);

                if (visit[vertex2] == 0) {
                    queue.add(vertex2);
                    visit[vertex2] = 1;
                    flag = false;
                }
            }

            if (flag) {
                sb.append(queue.poll() + " ");
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

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

        dfs(graph, n, v);
        bfs(graph, n, v);
    }
}
