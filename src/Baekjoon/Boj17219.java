package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj17219 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String input1 = st.nextToken();
            String input2 = st.nextToken();

            map.put(input1, input2);
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            System.out.println(map.get(str));
        }
    }
}
