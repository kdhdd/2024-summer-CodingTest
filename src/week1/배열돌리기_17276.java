package week1;

import java.util.Scanner;

public class 배열돌리기_17276 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int[][] answer = new int[n][n];
            for (int i = 0; i < n; i++) {
                answer[i] = arr[i].clone();
            }

            boolean start;

            if (d > 0)
                start = true;
            else {
                d = d * -1;
                start = false;
            }

            int count = d / 45;

            for (int c = 0; c < count; c++) {
                for (int i = 0; i < n; i++) {
                    arr[i] = answer[i].clone();
                }

                if (start) {
                    // X의 주 대각선을 ((1,1), (2,2), …, (n, n)) 가운데 열 ((n+1)/2 번째 열)로 옮긴다.
                    for (int i = 0; i < n; i++) {
                        answer[i][n / 2] = arr[i][i];
                    }
                    // X의 가운데 열을 X의 부 대각선으로 ((n, 1), (n-1, 2), …, (1, n)) 옮긴다.
                    for (int i = 0, j = n - 1; i < n; i++, j--) {
                        answer[i][j] = arr[i][n / 2];
                    }
                    // X의 부 대각선을 X의 가운데 행 ((n+1)/2번째 행)으로 옮긴다.
                    for (int i = 0, j = n - 1; i < n; i++, j--) {
                        answer[n / 2][i] = arr[j][i];
                    }
                    // X의 가운데 행을 X의 주 대각선으로 옮긴다.
                    for (int i = 0; i < n; i++) {
                        answer[i][i] = arr[n / 2][i];
                    }
                } else {
                    for (int i = 0; i < n; i++) {
                        answer[n / 2][i] = arr[i][i];
                    }
                    for (int i = 0, j = n - 1; i < n; i++, j--) {
                        answer[j][i] = arr[n / 2][i];
                    }
                    for (int i = 0, j = n - 1; i < n; i++, j--) {
                        answer[j][n / 2] = arr[j][i];
                    }
                    for (int i = 0; i < n; i++) {
                        answer[i][i] = arr[i][n / 2];
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(answer[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
