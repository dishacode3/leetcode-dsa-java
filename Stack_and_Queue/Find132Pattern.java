package Stack_and_Queue;
import java.util.Stack;

public class Find132Pattern {

    public static boolean find132pattern(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        int second = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] < second) {
                return true;
            }

            while (!stack.isEmpty()
                    && nums[i] > stack.peek()) {

                second = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 3, 2};

        System.out.println(
            "Answer: " + find132pattern(nums1)
        );

        int[] nums2 = {1, 2, 3, 4};

        System.out.println(
            "Answer: " + find132pattern(nums2)
        );

        int[] nums3 = {3, 1, 4, 2};

        System.out.println(
            "Answer: " + find132pattern(nums3)
        );
    }
}