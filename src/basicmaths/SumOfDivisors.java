package basicmaths;

public class SumOfDivisors {
    static long sumOfDivisors(int N){
        // code here
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            // Add 'i' to all its multiples
            sum += (long) (N / i) * i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDivisors(10));
    }
}
