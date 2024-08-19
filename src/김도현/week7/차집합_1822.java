package 김도현.week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 차집합_1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<Integer> hashSetA = new HashSet<>();
        HashSet<Integer> hashSetB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            hashSetA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            hashSetB.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer i : hashSetA) {
            if (!hashSetB.contains(i)) {
                result.add(i);
            }
        }

        result.sort(Integer::compareTo);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (Integer i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
