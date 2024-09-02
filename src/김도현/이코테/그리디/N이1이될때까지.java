package 김도현.이코테.그리디;

import java.util.Scanner;

public class N이1이될때까지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int result = 0;

/*        while (n != 1) {
            if (n % k == 0) {
                n /= k;
            } else {
                n -= 1;
            }
            result++;
        }*/

        while (n >= k) {
            int target = (n / k) * k;
            result += (n - target);
            n = target;

            if (n < k) break;
            result++;
            n /= k;
        }

        result += (n - 1);

        System.out.println(result);
    }
}