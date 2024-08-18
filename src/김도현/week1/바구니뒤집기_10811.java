package 김도현.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 바구니뒤집기_10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++)
            list.add(i);

        while (M != 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            Collections.reverse(list.subList(i - 1, j));
            //System.out.println(list);
            M--;
        }

        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
    }
}