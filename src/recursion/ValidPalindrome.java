package recursion;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return s.contentEquals(sb);
    }
    static private boolean isPalindromeUsingTwoPointer(String s) {
        int left = 0, right = s.length()-1;
        while(left<right)
        {
            char l = s.charAt(left), r = s.charAt(right);
            if(!Character.isLetterOrDigit(l))
                left++;
            else if(!Character.isLetterOrDigit(r))
                right--;
            else if(Character.toLowerCase(l)!=Character.toLowerCase(r))
                return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
    static boolean palindromeRecursive(int i, String s){
        if(i>=s.length()/2) return true;
        if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
        return palindromeRecursive(i+1,s);
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("abba abba"));
        System.out.println(isPalindromeUsingTwoPointer("bababab"));
        System.out.println(palindromeRecursive(0,"bababab"));
    }

}
