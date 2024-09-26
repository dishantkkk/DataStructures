package linkedlist.singlylinkedlist;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node() {
        this.data = 0;
        this.next = null;
    }
    Node(int d) {
        this.data = d;
        this.next = null;
    }
}

class ConstructLL {
    static Node constructLL(int arr[]) {
        // code here
        Node head = new Node();
        Node node = new Node(arr[0]);
        head = node;
        for(int i=1;i<arr.length;i++) {
            node.next = new Node(arr[i]);
            node = node.next;
        }
        node.next = null;
        return head;
    }
    public static void main(String[] args) throws IOException {
        int[] arr = {1,2,3,4,5};
        Node ans = constructLL(arr);
        while (ans != null) {
            System.out.print(ans.data + " ");
            ans = ans.next;
        }
        System.out.println();
    }
}