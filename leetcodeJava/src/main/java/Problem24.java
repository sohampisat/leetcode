// 24. Swap Nodes in Pairs

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
    public ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        
        ListNode current = head;
        ListNode previous = null;
        
        while (current != null) {
            ListNode temp = current.next;
            if (temp == null) {
                break;
            }
            ListNode nextPair = temp.next;
            current.next = nextPair;
            temp.next = current;
            if (previous != null) {
                previous.next = temp;
            } else {
                head = temp;
            }
            
            previous = current;
            current = nextPair;
        }
        
        return head;
    }
}