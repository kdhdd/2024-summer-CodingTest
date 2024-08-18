package 김도현.week8.몸풀기;

import java.util.ArrayList;
import java.util.Stack;

// 탐색을 해야 할 때
// 스택(Stack)으로 설정함
public class 깊이우선탐색순회 {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {5, 6}};
        int start = 1;
        int n = 6;

        // 인접 리스트 생성
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        int[] visited = new int[n + 1];

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        // 시작 노드 푸쉬
        stack.push(start);

        while (!stack.isEmpty()) {
            // 시작 노드 팝 & 방문 처리
            int k = stack.pop();
            visited[k] = 1;
            result.add(k);

            for (int i = graph.get(k).size() - 1; i >= 0; i--) {
                int neighbor = graph.get(k).get(i);
                if (visited[neighbor] == 0)
                    stack.push(neighbor);
            }
        }

        System.out.println(result);
    }
}
