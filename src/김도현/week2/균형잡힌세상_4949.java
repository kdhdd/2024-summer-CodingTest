package 김도현.week2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class 균형잡힌세상_4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String answer;

        while (true) {
            String s = sc.nextLine();

            ArrayDeque<Character> stack = new ArrayDeque<>();

            if (s.equals("."))
                break;

            char[] a = s.toCharArray();
            for (char c : a) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                }
                else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else stack.push(c);
                }
                else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[')
                        stack.pop();
                    else stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                answer = "yes";
            }
            else {
                answer = "no";
            }

            System.out.println(answer);


        }
    }
}