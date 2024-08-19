package 김도현.week8.몸풀기;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

// 최단 경로를 찾을 때, 네트워크 분석 문제를 풀 때
// 큐(Queue)로 설정함
public class 너비우선탐색순회 {
    public static void main(String[] args) {
        int[][] edges = {{1, 3}, {3, 4}, {3, 5}, {5, 2}};
        int start = 1;
        int n = 5;

        // 인접리스트 생성 & 초기화
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        // 방문 배열
        int[] visited = new int[n + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();

        // 시작 노드
        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int k = queue.poll();
            result.add(k);

            for (int i = 0; i < graph.get(k).size(); i++) {
                int neighbor = graph.get(k).get(i);
                if (visited[neighbor] == 0) {
                    visited[neighbor] = 1;
                    queue.add(neighbor);
                }
            }

        }

        System.out.println(result);

    }
}
