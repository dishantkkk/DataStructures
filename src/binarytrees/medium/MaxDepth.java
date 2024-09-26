package binarytrees.medium;

import java.util.AbstractMap.SimpleEntry;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
    int val;
    Node left;
    Node right;

    Node() {}

    Node(int val) { this.val = val; }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaxDepth {
    static int maxDepth(Node root) { // DFS recursive
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    static int maxDepthUsingBFS(Node root) {
        if (root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        int level = 0;

        q.add(root);

        while (!q.isEmpty()) {
            // Get the number of nodes at the current level
            int size = q.size();

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                // Get the front node in the queue
                Node front = q.poll();

                // Enqueue left child if exists
                if (front.left != null) {
                    q.add(front.left);
                }

                // Enqueue right child if exists
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            // Increment level to move to the next level
            level++;
        }
        // Return the level, which represents the maximum depth of the tree
        return level;
    }


    static int maxDepthUsingDFSIterative(Node root) {
        if (root == null) return 0;

        Stack<SimpleEntry<Node, Integer>> stack = new Stack<>();  // Or we can create a custom pair class
        stack.push(new SimpleEntry<>(root, 1));
        int maxDepth = 0;

        while (!stack.isEmpty()) {
            SimpleEntry<Node, Integer> current = stack.pop();
            Node node = current.getKey();
            int depth = current.getValue();

            maxDepth = Math.max(maxDepth, depth);

            if (node.left != null) {
                stack.push(new SimpleEntry<>(node.left, depth + 1));
            }
            if (node.right != null) {
                stack.push(new SimpleEntry<>(node.right, depth + 1));
            }
        }

        return maxDepth;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(maxDepth(root));
        System.out.println(maxDepthUsingBFS(root));
        System.out.println(maxDepthUsingDFSIterative(root));
    }
}
