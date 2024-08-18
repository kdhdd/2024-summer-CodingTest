package 김도현.week2;

import java.util.Scanner;
import java.util.Stack;

public class 괄호의값_2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        Stack<Object> stack = new Stack<>();

        char[] a = s.toCharArray();
        boolean valid = true;

        for (char c : a) {
            if (c == '(' || c == '[') {
                stack.push(c);
            }
            else if (c == ')') {
                int temp = 0;
                while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                    temp += (int) stack.pop();
                }
                if (!stack.isEmpty() && stack.peek().equals('(')) {
                    stack.pop();
                    stack.push(temp == 0 ? 2 : temp * 2);
                } else {
                    valid = false;
                    break;
                }
            }
            else if (c == ']') {
                int temp = 0;
                while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                    temp += (int) stack.pop();
                }
                if (!stack.isEmpty() && stack.peek().equals('[')) {
                    stack.pop();
                    stack.push(temp == 0 ? 3 : temp * 3);
                } else {
                    valid = false;
                    break;
                }
            }
        }

        if (!valid || stack.isEmpty()) {
            System.out.println(0);
        } else {
            int answer = 0;
            while (!stack.isEmpty()) {
                if (stack.peek() instanceof Integer) {
                    answer += (int) stack.pop();
                } else {
                    answer = 0;
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}