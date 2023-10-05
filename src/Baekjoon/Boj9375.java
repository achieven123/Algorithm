package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj9375 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testCase; i++) {
            int n, ans = 1;
            HashMap<String, Integer> map = new HashMap<>();

            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                System.out.println(0);
                continue;
            }

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                String costume = st.nextToken();
                String type = st.nextToken();

                if (map.containsKey(type)) {
                    int cnt = map.get(type);
                    map.put(type, cnt + 1);
                } else {
                    map.put(type, 2);
                }
            }

            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                ans *= map.get(key);
            }

            System.out.println(ans - 1);
        }
    }
}
