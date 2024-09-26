package strings.medium;

public class MaximumNestingDepthOfParentheses {
    public static int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if (c == ')') {
                currentDepth--;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        String s = "(1)+((2))+(((3)))";
        System.out.println(maxDepth(s));
    }
}
