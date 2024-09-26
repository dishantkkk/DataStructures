package binarytrees.traversals;

public class CountNodes {
    static int countNodesOfLevels(int levels) {
        return (int)Math.pow(2, levels-1);
        // the maximum number of nodes at any level i is calculated by formula 2^i (or i-1)
    }

    public static void main(String[] args) {
        System.out.println(countNodesOfLevels(3));
    }
}
