package basicmaths;

public class Palindrome {
    static boolean isPalindrome(int x) {
        int n = x;
        int sign = x<0 ? -1 : 1;
        int rev = 0;
        while(n != 0) {
            rev = rev*10 + n%10;
            n/=10;
        }
        return x == rev*sign;
    }

    public static void main(String[] args) {
        int x = 232;
        System.out.println(isPalindrome(x));
    }
}
