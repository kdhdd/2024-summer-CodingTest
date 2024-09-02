package 김도현.이코테.그리디;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 큰수의법칙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int result = 0;

        ArrayList<Integer> num_List = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            num_List.add(sc.nextInt());
        }

        Collections.sort(num_List, Collections.reverseOrder()); // 내림차순 정렬

/*        while (true) {
            for (int i = 0; i < K; i++) {
                if (M == 0)
                    break;
                result += num_List.get(0);
                M--;
            }

            if (M == 0)
                break;
            result += num_List.get(1);
            M--;
        }*/

        int first = num_List.get(0);
        int second = num_List.get(1);

        int count = (M / (K + 1)) * K;
        count += M % (K + 1); // M이 (K + 1)로 나누어떨어지지 않을 경우

        result += count * first;
        result += (M - count) * second;

        System.out.println(result);
    }
}
