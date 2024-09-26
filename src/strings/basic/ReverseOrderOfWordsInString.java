package strings.basic;

import java.util.Stack;

public class ReverseOrderOfWordsInString {
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String reverseWordsUsingStack(String st) {
        Stack<String> stack = new Stack<>();
        String[] words = st.trim().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            stack.push(words[i]);
            if (i != words.length-1) {
                stack.push(" ");
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static String reverseWordsOptimized(String s) {
        int left = 0;
        int right = s.length() - 1;
        // Remove leading and trailing spaces
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (right >= left && s.charAt(right) == ' ') {
            right--;
        }
        String temp = "";
        String ans = "";
        // Iterate through the string
        while (left <= right) {
            char ch = s.charAt(left);
            if (ch != ' ') {
                temp += ch;  // Build the current word
            } else if (ch == ' ' && !temp.isEmpty()) {
                // If we hit a space and the current word (temp) is not empty
                if (!ans.equals("")) {
                    ans = temp + " " + ans;  // Add the word to the beginning of the result
                } else {
                    ans = temp;  // If it's the first word
                }
                temp = "";  // Reset the current word
            }
            left++;
        }
        // Add the last word to the result (if any)
        if (!temp.isEmpty()) {
            if (!ans.equals("")) {
                ans = temp + " " + ans;
            } else {
                ans = temp;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String st = "the sky  is blue";
        System.out.println(reverseWords(st));
        System.out.println(reverseWordsUsingStack(st));
        System.out.println(reverseWordsOptimized(st));
    }
}
