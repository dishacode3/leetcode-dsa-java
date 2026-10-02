package Stack_and_Queue;
public class RemoveKDigits {

    public static String removeKdigits(String num, int k) {

        StringBuilder stack = new StringBuilder();

        for (char digit : num.toCharArray()) {

            while (k > 0 &&
                   stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > digit) {

                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(digit);
        }

        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        int start = 0;

        while (start < stack.length() && stack.charAt(start) == '0') {
            start++;
        }

        String result = stack.substring(start);

        if (result.length() == 0) {
            return "0";
        }

        return result;
    }

    public static void main(String[] args) {

        String num = "1432219";
        int k = 3;

        System.out.println("Answer: " + removeKdigits(num, k));
    }
}