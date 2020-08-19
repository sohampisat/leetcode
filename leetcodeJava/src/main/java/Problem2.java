2. Add Two Numbers

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        int carry = 0;
        ListNode head = null, tail = null;
        while ((l1 != null) && (l2 != null)) {
            int temp = l1.val + l2.val + carry;
            if (temp > 9) {
                carry = 1;
                temp = temp % 10;
            } else {
                carry = 0;
            }
            if (head == null) {
                head = new ListNode(temp);
                tail = head;
            } else {
                tail.next = new ListNode(temp);
                tail = tail.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int temp = l1.val + carry;
            if (temp > 9) {
                carry = 1;
                temp = temp % 10;
            } else {
                carry = 0;
            }
            tail.next = new ListNode(temp);
            tail = tail.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int temp = l2.val + carry;
            if (temp > 9) {
                carry = 1;
                temp = temp % 10;
            } else {
                carry = 0;
            }
            tail.next = new ListNode(temp);
            tail = tail.next;
            l2 = l2.next;
        }
        
        if (carry == 1) {
            tail.next = new ListNode(1);
        }
        
        return head;
    }
}