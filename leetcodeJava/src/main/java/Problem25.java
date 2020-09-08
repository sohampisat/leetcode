// 25. Reverse Nodes in k-Group

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
    
    private void reverseList(ListNode head, ListNode tail) {
        ListNode current = head;
        ListNode previous = null;
        
        while (current != tail) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        tail.next = previous;
        
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if ((head == null) || (k == 1)) {
            return head;
        }
        
        ListNode currentHead = head;
        ListNode res = head;
        ListNode previous = null;
        
        while (currentHead != null) {
            boolean flag = true;
            ListNode tail = currentHead;
            int count = 1;
            while (count < k) {
                tail = tail.next;
                if (tail == null) {
                    flag = false;
                    break;
                }
                
                count++;
            }
            if (!flag) {
                if (previous != null) {
                    previous.next = currentHead;
                }
                break;
            }
            
            ListNode nextSet = tail.next;
            this.reverseList(currentHead, tail);
            if (previous == null) {
                res = tail;
            } else {
                previous.next = tail;
            }
            previous = currentHead;
            currentHead = nextSet;
        }
        
        return res;
    }
}