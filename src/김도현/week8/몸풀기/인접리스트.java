package 김도현.week8.몸풀기;

import java.util.ArrayList;

public class 인접리스트 {
    public static void main(String[] args) {
        int n = 4; // 노드 수
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // 인접 리스트 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        System.out.println(graph);

        // 간선 추가
        graph.get(1).add(2); // 1번 노드 -> 2번 노드
        graph.get(1).add(3); // 1번 노드 -> 3번 노드
        graph.get(2).add(1); // 2번 노드 -> 1번 노드
        graph.get(2).add(4); // 2번 노드 -> 4번 노드
        graph.get(3).add(1); // 3번 노드 -> 1번 노드
        graph.get(3).add(4); // 3번 노드 -> 4번 노드
        graph.get(4).add(2); // 4번 노드 -> 2번 노드
        graph.get(4).add(3); // 4번 노드 -> 3번 노드

        System.out.println(graph);

        // 출력
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " -> ");
            for (int j : graph.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
