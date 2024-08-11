package week7;

import java.util.HashSet;

public class 폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 2};

        int n = nums.length;
        int k = n / 2;

        int answer;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        if (k > set.size())
            answer = set.size();
        else
            answer = k;

        System.out.println(answer);
    }
}
