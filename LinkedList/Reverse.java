package LinkedList;

public class Reverse {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);

        Node reversedHead = reverse(root);
        while(reversedHead != null){
            if(reversedHead != null) System.out.print(reversedHead.data + "->");
            reversedHead = reversedHead.next;
        }
        System.out.println();



    }

    public static Node reverse(Node head) {
        Node curr = head, prev = null, next = curr;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

// 1->2->3->4->5->null


// test step by step
// curr = head = 1, prev = null, next = 2
// swap next and prev of curr
// next = 2, curr = 1->nul, prev = 1->nul
// curr = 2->3-4
