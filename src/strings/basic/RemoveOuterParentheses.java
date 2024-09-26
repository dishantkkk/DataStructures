package strings.basic;

import java.util.Stack;

public class RemoveOuterParentheses {
    public static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;
        // Loop through each character in the string
        for (char c : s.toCharArray()) {
            // If we encounter a closing bracket, reduce the depth first
            if (c == ')') {
                depth--;
            }
            // If the depth is not zero, it means we are within a valid primitive, so we add it to the result
            if (depth >= 1) {
                result.append(c);
            }
            // Increase depth when encountering an opening bracket
            if (c == '(') {
                depth++;
            }
        }
        return result.toString();
    }

    public static String removeOuterParenthesesUsingStack(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        // Traverse through the input string
        for (char c : s.toCharArray()) {
            // For an opening bracket, check if stack is not empty (not outermost)
            if (c == '(') {
                if (!stack.isEmpty()) {
                    result.append(c);  // Add to result if it's not the outermost '('
                }
                stack.push(c); // Push '(' to stack
            } else if (c == ')') {
                stack.pop();  // Pop from stack (valid pair formed)
                if (!stack.isEmpty()) {
                    result.append(c);  // Add to result if it's not the outermost ')'
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(removeOuterParentheses("(()())(())")); // Output: "()()()"
        System.out.println(removeOuterParentheses("(()())(())(()(()))")); // Output: "()()()()(())"
        System.out.println(removeOuterParentheses("()()")); // Output: ""

        System.out.println(removeOuterParenthesesUsingStack("(()())(())")); // Output: "()()()"
        System.out.println(removeOuterParenthesesUsingStack("(()())(())(()(()))")); // Output: "()()()()(())"
        System.out.println(removeOuterParenthesesUsingStack("()()")); // Output: ""
    }
}
