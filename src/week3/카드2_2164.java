package week3;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 카드2_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        System.out.println(queue);

        int count = 1;

        while (queue.size() != 1) {
            if (count == 2) {
                queue.add(queue.poll());
                count--;
            } else {
                queue.poll();
                count++;
            }
        }
        System.out.println(queue.poll());
    }
}
