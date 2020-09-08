// 21. Merge Two Sorted Lists

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        ListNode head = null;
        ListNode tail = null;
        
        while ((l1 != null) && (l2 != null)) {
            ListNode nextNode = l1;
            if (l1.val > l2.val) {
                nextNode = l2;
                l2 = l2.next;
            } else {
                l1 = l1.next;
            }
            if (head == null) {
                head = nextNode;
                tail = nextNode;
            } else {
                tail.next = nextNode;
                tail = nextNode;
            }
        }
        
        while (l1 != null) {
            tail.next = l1;
            tail = l1;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            tail.next = l2;
            tail = l2;
            l2 = l2.next;
        }
        
        return head;
    }
}