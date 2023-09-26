package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj10798 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        char[][] array = new char[5][16];

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();

            int length = str.length();
            for (int j = 0; j < length; j++) {
                array[i][j] = str.charAt(j);
            }

            array[i][length] = '\0';
        }


        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (array[j][i] == '\0') continue;

                System.out.print(array[j][i]);
            }
        }
    }
}
