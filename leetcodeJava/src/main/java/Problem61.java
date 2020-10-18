// 61. Rotate List

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
    
    private int getListLength(ListNode head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        int listLength = this.getListLength(head);
        k = k % listLength;
        if (k == 0) {
            return head;
        }
        ListNode runner = head;
        int count = 1;
        while (count < k) {
            count++;
            runner = runner.next;
        }
        ListNode current = head;
        ListNode previous = null;
        while (runner.next != null) {
            previous = current;
            current = current.next;
            runner = runner.next;
        }
        previous.next = null;
        runner.next = head;
        return current;
    }
}