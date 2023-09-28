package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj14002 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int[] inputData = new int[size];
        int[] count = new int[size];
        int[] ansArr;
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

        ansArr = new int[ans];
        int idx = 0;

        for (int i = size - 1; i >= 0; i--) {
            if (count[i] == ans) {
                ansArr[idx++] = inputData[i];
                ans--;
            }
        }

        for (int i = idx - 1; i >= 0; i--) {
            System.out.print(ansArr[i] + " ");
        }
    }
}
