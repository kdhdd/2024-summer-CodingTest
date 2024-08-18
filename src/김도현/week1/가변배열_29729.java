package 김도현.week1;

import java.util.Scanner;

public class 가변배열_29729 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        int answer = 0;

        for (int i = 0; i < N+M; i++) {
            int order = sc.nextInt();
            if (order == 1) {
                if (S == answer)
                    S += S;
                answer += 1;
            }
            else
                answer -= 1;
        }

        System.out.println(S);
    }
}