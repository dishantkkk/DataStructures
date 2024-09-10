package recursion;

public class PrintGFG {
    static void printGfg(int N) {
        // code here
        if (N == 0) {
            return;
        }
        System.out.print("GFG ");
        printGfg(N - 1);
    }

    public static void main(String[] args) {
        printGfg(10);
    }
}
