package 김도현.week8.몸풀기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 다익스트라알고리즘 {
    // 인접 리스트에 노드와 가중치를 저장하기 위함
    static class Pair implements Comparable<Pair> {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair other) {
            return this.weight - other.weight; // 오름차순 정렬
        }

        // 디버깅을 위한 출력 용도
        @Override
        public String toString() {
            return "(" + node + ", " + weight + ")";
        }
    }
    public static void main(String[] args) {
        int[][] edges = {{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}};
        int start = 0;
        int n = 3;

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        System.out.println(graph);

        int[] visited = new int[n];
        int[] cost = new int[n];

        // 가중치를 최대값으로 초기화
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Integer.MAX_VALUE;
        }
        cost[start] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int currentNode = current.node;
            int currentWeight = current.weight;

            if (visited[currentNode] == 0)
                visited[currentNode] = 1;

            for (Pair neighbor : graph.get(currentNode)) {
                int nextNode = neighbor.node;
                int nextWeight = neighbor.weight;

                if (cost[nextNode] > currentWeight + nextWeight) {
                    cost[nextNode] = currentWeight + nextWeight;
                    pq.add(new Pair(nextNode, cost[nextNode]));
                }
            }
        }

        System.out.println(Arrays.toString(cost));
    }

}
