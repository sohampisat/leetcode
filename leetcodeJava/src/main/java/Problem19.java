// 19. Remove Nth Node From End of List

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
        if (head == null) {
            return head;
        }
        
        ListNode runner = head;
        int count = 1;
        while (count < n) {
            runner = runner.next;
            count++;
        }
        
        ListNode current = head;
        ListNode prev = null;
        while (runner.next != null) {
            prev = current;
            runner = runner.next;
            current = current.next;
        }
        
        if (current == head) {
            return head.next;
        }
        
        prev.next = current.next;
        
        return head;
    }
}