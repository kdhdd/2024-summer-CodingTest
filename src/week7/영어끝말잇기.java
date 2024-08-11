package week7;

import java.util.Arrays;
import java.util.HashSet;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        int[] answer = solution(n, words);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(int n, String[] words) {
        HashSet<String> usedwords = new HashSet<>();

        char prevword = words[0].charAt(0);

        for (int i = 0; i < words.length; i++) {
            if (usedwords.contains(words[i]) || words[i].charAt(0) != prevword) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            usedwords.add(words[i]);
            prevword = words[i].charAt(words[i].length() - 1);
        }

        return new int[]{0, 0};
    }
}
