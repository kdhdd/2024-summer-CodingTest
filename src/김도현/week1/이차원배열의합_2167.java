package 김도현.week1;

import java.util.Scanner;

public class 이차원배열의합_2167 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int K = sc.nextInt();

        while (K != 0) {
            int count = 0;
            int i = sc.nextInt();
            int j = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            // 1행보다 크고 2행보다 작은, 1열보다 크고 3열보다 작은
            for (int n = i - 1; n < x; n++) {
                for (int m = j -1; m < y; m++) {
                    count += arr[n][m];
                }
            }
            System.out.println(count);
            K--;
        }
    }
}