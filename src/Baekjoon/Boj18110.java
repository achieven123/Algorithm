package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Boj18110 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        ArrayList<Integer> list = new ArrayList<>();
        int numOfOpinion = Integer.parseInt(br.readLine());
        int numberOfException = (int)(Math.round(numOfOpinion * 0.15));
        int num, sum = 0;
        double answer;

        for (int i = 0; i < numOfOpinion; i++) {
            num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        list.sort(Comparator.naturalOrder());

        for (int i = numberOfException; i < numOfOpinion - numberOfException; i++) {
            sum += list.get(i);
        }

        answer = sum / (double)(numOfOpinion - 2 * numberOfException);

        System.out.println(Math.round(answer));
    }
}
