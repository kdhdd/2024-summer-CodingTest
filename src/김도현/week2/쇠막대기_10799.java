package 김도현.week2;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기_10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        int answer = 0;

        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '(') {
                stack.push(a[i]);
            }
            else if (a[i] == ')') {
                stack.pop();
                if (a[i - 1] == '(') {
                    answer += stack.size();
                }
                else {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
