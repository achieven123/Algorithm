package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Boj1764 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<String, Boolean> map = new HashMap<>();
        TreeSet<String> set = new TreeSet<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            map.put(br.readLine(), false);
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();

            if (map.get(str) != null) {
                set.add(str);
            }
        }

        System.out.println(set.size());

        for (String str : set) {
            System.out.println(str);
        }
    }
}
