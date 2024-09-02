package 김도현.이코테.구현;

import java.util.Scanner;

public class 상하좌우 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        String[] plans = sc.nextLine().split(" ");

        int x = 1;
        int y = 1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        String[] types = {"L", "R", "U", "D"};

        for (String plan : plans) {
            for (int i = 0; i < 4; i++) {
                if (plan.equals(types[i])) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 1 && ny >= 1 && nx <= N && ny <= N) {
                        x = nx;
                        y = ny;
                    }
                }
            }
        }

        System.out.println(x + " " + y);

        sc.close();
    }
}
