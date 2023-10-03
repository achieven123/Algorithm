package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj1620 {

    public static boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap();
        String[] strArr = new String[n +1];

        for (int i = 1; i < n + 1; i++) {
            String str = br.readLine();
            map.put(str, i);
            strArr[i] = str;
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();

            if (isInteger(str) == true) {
                System.out.println(strArr[Integer.parseInt(str)]);
            } else {
                System.out.println(map.get(str));
            }
        }
    }
}
