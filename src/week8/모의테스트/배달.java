package week8.모의테스트;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 배달 {
    public static void main(String[] args) {
        int[][] roads = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int n = 5; // 마을 개수
        int k = 3; // 배달 시간

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[0]).add(new Pair(road[1], road[2]));
            graph.get(road[1]).add(new Pair(road[0], road[2]));
        }

        int count = 0;

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(1, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int curretnNode = pair.node;
            int currentWeight = pair.weight;

            for (Pair neighbor : graph.get(curretnNode)) {
                int nextNode = neighbor.node;
                int nextWeight = neighbor.weight;

                if (dist[nextNode] > currentWeight + nextWeight) {
                    dist[nextNode] = currentWeight + nextWeight;
                    pq.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        for (int i : dist) {
            if (i <= k)
                count++;
        }

        System.out.println(count);

    }
    private static class Pair implements Comparable<Pair> {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }

        @Override
        public String toString() {
            return "(" + node + ", " + weight + ")";
        }
    }
}
