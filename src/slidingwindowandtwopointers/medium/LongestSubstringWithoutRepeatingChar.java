package slidingwindowandtwopointers.medium;
import java.util.*;

public class LongestSubstringWithoutRepeatingChar {
    static int findLongestSubstringWithoutRepeatingCharBruteForce(String str) {
        if(str.isEmpty())
            return 0;
        int maxans = Integer.MIN_VALUE;
        for(int i = 0;i<str.length();i++) {
            Set < Character > se = new HashSet < > ();
            for (int j = i; j < str.length(); j++) {
                if (se.contains(str.charAt(j))) {
                    maxans = Math.max(maxans, j - i);
                    break;
                }
                se.add(str.charAt(j));
            }
        }
        return maxans;
    }

    static int findLongestSubstringWithoutRepeatingChar(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int maxLength = 0;
        int left = 0;
        Set<Character> seenChars = new HashSet<>();
        for (int right = 0; right < str.length(); right++) {
            while (seenChars.contains(str.charAt(right))) {
                seenChars.remove(str.charAt(left));
                left++;
            }
            seenChars.add(str.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    static int findLongestSubstringWithoutRepeatingCharUsingMap(String s) {
        HashMap <Character,Integer> mpp = new HashMap <Character,Integer>();
        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) left = Math.max(mpp.get(s.charAt(right)) + 1, left);
            mpp.put(s.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(findLongestSubstringWithoutRepeatingCharBruteForce(str));
        System.out.println(findLongestSubstringWithoutRepeatingChar(str));
        System.out.println(findLongestSubstringWithoutRepeatingCharUsingMap(str));

    }
}
