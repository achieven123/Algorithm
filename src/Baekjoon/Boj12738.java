package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12738 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int[] min = new int[size + 1];
        int num, idx = 0;

        st = new StringTokenizer(br.readLine());

        min[0] = -1000000001;

        for (int i = 0; i < size; i++) {
            num = Integer.parseInt(st.nextToken());
            int left = 0, right = idx, mid = 0;

            while (left <= right) {
                mid = (left + right) / 2;

                if (min[mid] < num) left = mid + 1;
                else if (min[mid] > num) right = mid - 1;
                else break;
            }

            if (min[right] < num) {
                if (right == idx) idx++;
                min[right + 1] = num;
            }
        }

        System.out.println(idx);
    }
}
