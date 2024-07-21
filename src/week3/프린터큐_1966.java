package week3;

import java.util.*;

public class 프린터큐_1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int repeat = sc.nextInt();

        while (repeat-- > 0) {
            Queue<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            int N = sc.nextInt();
            int M = sc.nextInt();

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                queue.add(new AbstractMap.SimpleEntry<>(i, x));
                pq.add(x);
            }
            System.out.println(queue);
            System.out.println(pq);

            int count = 0;

            while(!queue.isEmpty()) {
                Map.Entry<Integer, Integer> map = queue.poll();
                if (map.getValue().equals(pq.peek())) {
                    pq.poll();
                    count++;
                    if (map.getKey() == M) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    queue.add(map);
                }
            }

        }

    }
}
