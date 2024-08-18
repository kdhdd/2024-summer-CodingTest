package 김도현.week8.모의테스트;

import java.util.ArrayDeque;

public class 미로탈출 {
    public static void main(String[] args) {
        String[] maps = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};

        int n = maps.length;
        int m = maps[0].length();

        // 맵을 2차원 배열로 만들기
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }

        int sRow = 0, sCol = 0, lRow = 0, lCol = 0, eRow = 0, eCol = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'S') {
                    sRow = i;
                    sCol = j;
                }
                if (map[i][j] == 'L') {
                    lRow = i;
                    lCol = j;
                }
                if (map[i][j] == 'E') {
                    eRow = i;
                    eCol = j;
                }
            }
        }

        int StartToLever = bfs(new Node(sRow, sCol), new Node(lRow, lCol), map, n, m);
        int LeverToEnd = bfs(new Node(lRow, lCol), new Node(eRow, eCol), map, n, m);

        if (StartToLever == -1 || LeverToEnd == -1)
            System.out.println(-1);
        else
            System.out.println(StartToLever + LeverToEnd);
    }

    private static class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static int bfs(Node start, Node end, char[][] map, int n, int m) {
        ArrayDeque<Node> deque = new ArrayDeque<>();

        int[][] dist = new int[n][m];
        dist[start.row][start.col] = 1;

        deque.addLast(start);

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!deque.isEmpty()) {
            Node current = deque.pollFirst();

            if (current.row == end.row && current.col == end.col)
                return dist[current.row][current.col] - 1;

            for (int i = 0; i < 4; i++) {
                int nx = current.row + dx[i];
                int ny = current.col + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if (map[nx][ny] == 'X')
                    continue;

                if (dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[current.row][current.col] + 1;
                    deque.addLast(new Node(nx, ny));
                }

            }
        }

        return -1;
    }
}
