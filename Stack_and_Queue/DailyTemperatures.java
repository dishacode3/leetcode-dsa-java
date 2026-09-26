package Stack_and_Queue;
import java.util.Stack;
import java.util.Arrays;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int previousIndex = stack.pop();

                answer[previousIndex] = i - previousIndex;
            }

            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] temperatures = {
            73, 74, 75, 71, 69, 72, 76, 73
        };

        int[] result = dailyTemperatures(temperatures);

        System.out.println(Arrays.toString(result));
    }
}