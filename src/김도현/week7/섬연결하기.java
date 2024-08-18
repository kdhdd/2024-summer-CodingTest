package 김도현.week7;

import java.util.Arrays;
import java.util.Comparator;

public class 섬연결하기 {
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        System.out.println(solution(n, costs));
    }
    private static int[] parent;
    
    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
    
    private static int solution(int n, int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2]; // 오름차선
              //return o2[2] - o1[2]; // 내림차순
            }
        });

/*        for (int[] cost : costs) {
            for (int i : cost) {
                System.out.print(i + " ");
            }
            System.out.println();
        }*/

        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int result = 0;
        int count = 0;

        for (int[] cost : costs) {
            // N개의 섬을 연결하려면 N-1의 다리가 필요하므로 N-1개의 다리가 선택될 때까지.
            if (count == n - 1) {
                break;
            }

            if (find(cost[0]) != find(cost[1])) {
                union(find(cost[0]), find(cost[1]));
                result += cost[2];
                count++;
            }
        }
        return result;
    }
}
