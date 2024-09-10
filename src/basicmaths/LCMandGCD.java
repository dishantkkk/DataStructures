package basicmaths;

public class LCMandGCD {
    static Long[] lcmAndGcd(Long A , Long B) {
        // code here
        Long a=A, b=B;
        // Implements the Euclidean algorithm to compute the GCD of two numbers.
        // It keeps reducing the problem using the formula gcd(a, b) = gcd(b, a % b) until b becomes zero.
        while (b != 0) {
            Long temp = b;
            b = a % b;
            a = temp;
        }
        Long gcdValue = a;
        // it calculates the LCM using the formula LCM(a, b) = |a * b| / GCD(a, b).
        long lcmValue = Math.abs(A * B) / gcdValue;

        return new Long[]{lcmValue, gcdValue};
    }

    public static void main(String[] args) {
        Long A = 5L;
        Long B = 10L;
        Long[] result = lcmAndGcd(A, B);
        System.out.println("LCM = "+result[0]);
        System.out.println("GCD = "+result[1]);
    }
}
