package week3;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 트럭_13335 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int w = sc.nextInt();
        int L = sc.nextInt();

        Queue<Integer> trucks = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            trucks.add(sc.nextInt());
        }

        Queue<Integer> bridges = new ArrayDeque<>();
        int currentWeight = 0; // 다리 위의 현재 무게
        int time = 0;  // 경과 시간

        for (int i = 0; i < w; i++) {
            bridges.add(0);
        }

        System.out.println(trucks);
        System.out.println(bridges);

        while (!bridges.isEmpty()) {
            time++;
            currentWeight -= bridges.poll();

            if (!trucks.isEmpty()) {
                if (currentWeight + trucks.peek() <= L) {
                    int nextTruck = trucks.poll();
                    bridges.add(nextTruck);
                    currentWeight += nextTruck;
                } else {
                    bridges.add(0);
                }
            }
        }

        System.out.println(time);
    }
}
