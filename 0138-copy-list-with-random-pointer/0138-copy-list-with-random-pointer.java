/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        
        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        Node curr = newHead;

        while (curr != null) {
            if (head.next != null) {
                Node next = map.getOrDefault(head.next, new Node(head.next.val));
                curr.next = next;
                map.put(head.next, next);
            }
            if (head.random != null) {
                Node random = map.getOrDefault(head.random, new Node(head.random.val));
                curr.random = random;
                map.put(head.random, random);
            }
            head = head.next;
            curr = curr.next;
        }

        return newHead;
    }
}
