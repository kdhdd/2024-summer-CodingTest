package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사이클게임_20040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];

        int result = 0;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (!union(x, y)) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
    private static int[] parent;

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static boolean union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);

        if (root1 == root2)
            return false;

        parent[root2] = root1;
        return true;
    }
}
