package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11054 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int[] input = new int[size + 1];
        int[] count1 = new int[size + 1];
        int[] count2 = new int[size + 1];
        int[] count = new int[size + 1];
        int ans = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++) {
            int addCount = 0;
            count1[i] = 1;
            input[i] = Integer.parseInt(st.nextToken());

            for (int j = i; j > 0; j--) {
                if (input[j - 1] < input[i]) {
                    if (count1[j - 1] > addCount) addCount = count1[j - 1];
                }
            }

            count1[i] += addCount;
        }

        for (int i = size - 1; i >= 0; i--) {
            int addCount = 0;
            count2[i] = 1;

            for (int j = i; j < size; j++) {
                if (input[j + 1] < input[i]) {
                    if (count2[j + 1] > addCount) {
                        addCount = count2[j + 1];
                    }
                }
            }

            count2[i] += addCount;
        }

        for (int i = 0; i < size; i++) {
            count[i] = count1[i] + count2[i] - 1;
            if (count[i] > ans) {
                ans = count[i];
            }
        }

        System.out.println(ans);
    }
}
