package Stack_and_Queue;
import java.util.*;

public class SumSubarrayRanges {

    private static long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() &&
                   (i == n || arr[stack.peek()] >= arr[i])) {

                int index = stack.pop();

                int left;
                if (stack.isEmpty()) {
                    left = index + 1;
                } else {
                    left = index - stack.peek();
                }

                int right = i - index;

                sum += (long) arr[index] * left * right;
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return sum;
    }

    private static long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        long sum = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {

            while (!stack.isEmpty() &&
                   (i == n || arr[stack.peek()] <= arr[i])) {

                int index = stack.pop();

                int left;
                if (stack.isEmpty()) {
                    left = index + 1;
                } else {
                    left = index - stack.peek();
                }

                int right = i - index;

                sum += (long) arr[index] * left * right;
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        long minSum = sumSubarrayMins(arr);
        long maxSum = sumSubarrayMaxs(arr);

        long answer = maxSum - minSum;

        System.out.println("Sum of Subarray Ranges = " + answer);
    }
}