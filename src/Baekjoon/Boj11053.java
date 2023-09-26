package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11053 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int[] inputData = new int[size];
        int[] count = new int[size];
        int ans = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++) {
            int addCount = 0;
            count[i] = 1;
            inputData[i] = Integer.parseInt(st.nextToken());

            for (int j = i; j > 0; j--) {
                if (inputData[j - 1] < inputData[i]) {
                    if (count[j - 1] > addCount) addCount = count[j - 1];
                }
            }

            count[i] += addCount;

            if (count[i] > ans) ans = count[i];
        }

        System.out.println(ans);
    }
}
