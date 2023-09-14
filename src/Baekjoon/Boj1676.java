package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Boj1676 {

//    처음 푼 방법
//    public static void main(String[] args) throws IOException {
//        InputStream in = System.in;
//        InputStreamReader reader = new InputStreamReader(in);
//        BufferedReader br = new BufferedReader(reader);
//
//        int num = Integer.parseInt(br.readLine());
//        int fac = 1, count = 0;
//
//        for (int i = 1; i <= num; i++) {
//            fac *= i;
//
//            while (fac % 10 == 0) {
//                count++;
//                fac /= 10;
//            }
//
//            fac %= 1000;
//        }
//
//        System.out.println(count);
//    }

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        int num = Integer.parseInt(br.readLine());
        int count = 0;

        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }

        System.out.println(count);
    }
}
