package Stack_and_Queue;

public class Main {

    public static String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
                sb.append(ch);
            } else if (ch == ')') {
                if (open > 0) {
                    open--;
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);

            if (ch == '(' && open > 0) {
                open--;
            } else {
                ans.append(ch);
            }
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";

        System.out.println(minRemoveToMakeValid(s));
    }
}
