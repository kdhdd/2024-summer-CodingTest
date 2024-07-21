package week3;

import java.util.*;

public class 뱀_3190 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 보드의 크기
        int N = sc.nextInt();
        int[][] matrix = new int[N][N];

        // 사과 위치 입력
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            matrix[row][col] = 1; // 사과의 위치
        }

        // 방향 전환 입력
        int L = sc.nextInt();
        Map<Integer, String> dict = new HashMap<>();
        for (int i = 0; i < L; i++) {
            int x = sc.nextInt();
            String c = sc.next();
            dict.put(x, c);
        }

        int time = 0;
        int directionIndex = 0;
        int[] dx = {0, 1, 0, -1}; // 동 남 서 북
        int[] dy = {1, 0, -1, 0};
        // 동쪽으로 이동하면 열(Col)이 증가

        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{0, 0});
        matrix[0][0] = 2; // 뱀의 시작 위치

        while (true) {
            time++;
            int[] head = snake.peekFirst();
            int nx = head[0] + dx[directionIndex];
            int ny = head[1] + dy[directionIndex];

            // 벽이나 자기자신의 몸과 부딪히면 게임종료
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || matrix[nx][ny] == 2) {
                break;
            }

            // 사과가 있다면
            if (matrix[nx][ny] == 1) {
                matrix[nx][ny] = 2;
                snake.addFirst(new int[]{nx, ny});
            } else {
                matrix[nx][ny] = 2;
                snake.addFirst(new int[]{nx, ny});
                int[] tail = snake.pollLast();
                matrix[tail[0]][tail[1]] = 0;
            }

            // 방향 전환
            if (dict.containsKey(time)) {
                String turn = dict.get(time);
                if (turn.equals("L")) {
                    directionIndex = (directionIndex + 3) % 4;
                } else if (turn.equals("D")) {
                    directionIndex = (directionIndex + 1) % 4;
                }
            }

        }
        System.out.println(time);
    }
}
