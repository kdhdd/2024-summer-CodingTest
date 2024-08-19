package 김도현.week8.모의테스트;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// 깊이 우선 탐색
public class 네트워크 {
    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n = 3;

        int[] visited = new int[n];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1)
                    graph.get(i).add(j);
            }
        }

        // 네트워크의 수
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);

                while (!stack.isEmpty()) {
                    int k = stack.pop();
                    visited[k] = 1;

                    for (int neighbor : graph.get(k)) {
                        if (visited[neighbor] == 0)
                            stack.push(neighbor);
                    }
                }
                count++;
            }
        }

        System.out.println(count);
    }
}
