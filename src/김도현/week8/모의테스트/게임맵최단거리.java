package 김도현.week8.모의테스트;

import java.util.ArrayDeque;

public class 게임맵최단거리 {
    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        int n = maps.length;
        int m = maps[0].length;

        int[][] dist = new int[n][m];
        dist[0][0] = 1;

        int[] dx = {0, 1, 0, -1}; // 동 남 서 북
        int[] dy = {1, 0, -1, 0};

        // 비용이 1 고정이니까 덱큐로 시도
        ArrayDeque<Node> queue = new ArrayDeque<>();

        queue.addLast(new Node(0, 0));

        while(!queue.isEmpty()) {
            Node current = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = current.row + dx[i];
                int ny = current.col + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if (maps[nx][ny] == 0)
                    continue;

                if (dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[current.row][current.col] + 1;
                    queue.addLast(new Node(nx, ny));
                }
            }

        }
        System.out.println(dist[n - 1][m - 1]);
    }

    private static class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
