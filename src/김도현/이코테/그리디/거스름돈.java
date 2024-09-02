package 김도현.이코테.그리디;

import java.util.Scanner;

public class 거스름돈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 거슬러 줘야 할 돈
        int count = 0;

        int[] coin_types = {500, 100, 50, 10};

        for (int coinType : coin_types) {
            count += N / coinType;
            N %= coinType;
        }

        System.out.println(count);
    }
}
