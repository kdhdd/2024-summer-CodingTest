package 김도현.week1;

import java.util.Scanner;

public class 색종이_2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int area = 0;

        int[][] matrix = new int[100][100];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    matrix[j][k] = 1;
                }
            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    area++;
                }
            }
        }

        System.out.println(area);
    }
}
