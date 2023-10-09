package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Boj1541 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        String input = "+" + br.readLine() + "+";
        int length = input.length();
        int ans = 0;
        boolean flag = false;

        StringBuilder operand = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char letter = input.charAt(i);

            if (Character.isDigit(letter) == true || letter == '0') {
                operand.append(letter);
            } else {
                if (operand.length() != 0) {
                    if (flag == true) ans -= Integer.parseInt(operand.toString());
                    else ans += Integer.parseInt(operand.toString());

                    operand.setLength(0);
                }

                if (letter == '-') {
                    flag = true;
                }
            }
        }

        System.out.println(ans);
    }
}
