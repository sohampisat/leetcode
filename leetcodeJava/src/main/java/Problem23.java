// 23. Merge k Sorted Lists

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
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        ListNode head = null;
        ListNode tail = null;
        
        while ((l1 != null) && (l2 != null)) {
            ListNode newNode = l1;
            if (l1.val > l2.val) {
                newNode = l2;
                l2 = l2.next;
            } else {
                l1 = l1.next;
            }
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
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
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        
        List<ListNode> current = new ArrayList<ListNode>();
        for (ListNode listHead : lists) {
            current.add(listHead);
        }
        
        while (current.size() != 1) {
            List<ListNode> nextArray = new ArrayList<ListNode>();
            for (int i = 0; i < current.size() - 1; i = i + 2) {
                ListNode mergedList = this.mergeTwoLists(current.get(i), current.get(i + 1));
                nextArray.add(mergedList);
            }
            
            if (current.size() % 2 == 1) {
                nextArray.add(current.get(current.size() - 1));
            }
            
            current = nextArray;
        }
        
        return current.get(0);
    }
}