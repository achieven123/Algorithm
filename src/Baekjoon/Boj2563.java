package Baekjoon;

import java.util.Scanner;

public class Boj2563 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] drawingPaper = new int[101][101];
        int coloredPaper = sc.nextInt();
        int positionX, positionY;
        int area = 0;

        for (int i = 0; i < coloredPaper; i++) {
            positionX = sc.nextInt();
            positionY = sc.nextInt();

            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) {
                    drawingPaper[positionY + y][positionX + x] = 1;
                }
            }
        }

        for (int y = 0; y < 101; y++) {
            for (int x = 0; x < 101; x++) {
                if (drawingPaper[y][x] == 1) {
                    area++;
                }
            }
        }

        System.out.println(area);
    }
}
