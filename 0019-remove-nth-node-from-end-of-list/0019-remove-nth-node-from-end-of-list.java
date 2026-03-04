/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode l = root, r = root;

        // Move r to l + n position
        for (int i = 0; i < n; i++) {
            r = r.next;
        }

        // When r reaches the end node, l is 1 node ahead of the Nth node from the end
        while (r.next != null) {
            l = l.next;
            r = r.next;
        }

        l.next = l.next.next;
        return root.next;
    }
}
