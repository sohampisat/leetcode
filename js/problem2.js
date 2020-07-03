/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    if (l1 == null) {
        return l2;
    }
    
    if (l2 == null) {
        return l1;
    }
    
    let head = null, tail = null;
    let carry = 0;
    
    while ((l1 != null) && (l2 != null)) {
        let temp = l1.val + l2.val + carry;
        if (temp > 9) {
            carry = 1;
            temp = temp % 10;
        } else {
            carry = 0;
        }
        
        let newNode = new ListNode(temp, null);
        
        if (head === null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        
        l1 = l1.next;
        l2 = l2.next;
    }
    
    if (l1 !== null) {
        while (l1 !== null) {
            let temp = l1.val + carry;
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
    } else if (l2 !== null) {
        while (l2 !== null) {
            let temp = l2.val + carry;
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
    }
    
    if (carry !== 0) {
        tail.next = new ListNode(1);
    }
    
    return head;
};