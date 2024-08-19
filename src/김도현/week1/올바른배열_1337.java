package 김도현.week1;

import java.util.Arrays;
import java.util.Scanner;

public class 올바른배열_1337 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int answer = 4;

        for (int i = 0; i < N; i++) {
            int start = i, end = N - 1;
            while (start < end) {
                if (arr[end] - arr[start] > 4)
                    end -= 1;
                else {
                    int temp_answer = 4 - (end - start);
                    answer = Math.min(temp_answer, answer);
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}