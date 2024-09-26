package linkedlist.doublylinkedlist;

class Node {
    public int data;
    public Node next;
    public Node previous;
    public Node(int data, Node next, Node back) {
        this.data = data;
        this.next = next;
        this.previous = back;
    }
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}

public class ConstructDLL {
    static Node constructDLL(int arr[]) {
        // Code here
        Node head=new Node(arr[0]);
        Node temp=head;
        for(int i=1;i<arr.length;i++){
            Node newnode=new Node(arr[i]);
            temp.next=newnode;
            newnode.previous=temp;
            temp=temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Node ans = constructDLL(arr);
        while (ans != null) {
            System.out.print(ans.data + " ");
            ans = ans.next;
        }
        System.out.println();
    }
}
