package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj11723 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int S = 0;
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (str.equals("all")) {
                S = ~0;
            } else if (str.equals("empty")) {
                S = 0;
            } else {
                int idx = Integer.parseInt(st.nextToken());
                if (str.equals("add")) {
                    S |= (1 << idx);
                } else if (str.equals("remove")) {
                    S &= ~(1 << idx);
                } else if (str.equals("toggle")) {
                    S ^= (1 << idx);
                } else if (str.equals("check")) {
                    if ((S & (1 << idx)) != 0) {
                        sb.append("1\n");
                    }
                    else sb.append("0\n");
                }
            }
        }

        System.out.println(sb);
    }
}
