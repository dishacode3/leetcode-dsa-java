package Stack_and_Queue;

import java.util.Stack;

public class EvaluateRPN {

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")) {

                int b = stack.pop();
                int a = stack.pop();

                int result = 0;

                if (token.equals("+")) {
                    result = a + b;
                }
                else if (token.equals("-")) {
                    result = a - b;
                }
                else if (token.equals("*")) {
                    result = a * b;
                }
                else {
                    result = a / b;
                }

                stack.push(result);
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        String[] tokens = {"2", "1", "+", "3", "*"};

        System.out.println("Answer: " + evalRPN(tokens));
    }
}

