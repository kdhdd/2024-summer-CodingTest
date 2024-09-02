package 김도현.이코테.그리디;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 숫자카드게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int result = 0;

        for (int i = 0; i < n; i++) {
            int minValue = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int value = sc.nextInt();
                if (value < minValue) {
                    minValue = value;
                }
            }
            if (minValue > result) {
                result = minValue;
            }
        }

        System.out.println(result);
        sc.close();

/*        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                list.get(i).add(sc.nextInt());
            }
        }

        ArrayList<Integer> min_Nums = new ArrayList<>(); // 각 행의 가장 작은 수들

        for (int i = 0; i < n; i++) {
            int min = Collections.min(list.get(i));
            min_Nums.add(min);
        }

        int result = Collections.max(min_Nums);

        System.out.println(result);*/
    }
}
