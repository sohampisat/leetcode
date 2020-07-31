/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */

const getListLength = function(head) {
    if (head === null) {
        return 0;
    }
    let current = head, res = 0;
    while (current) {
        current = current.next;
        res++;
    }
    
    return res;
};

var rotateRight = function(head, k) {
    if ((!head) || (!head.next)) {
        return head;
    }
    let listLength = getListLength(head);
    k = k % listLength;
    if ((listLength === k) || (k === 0)) {
        return head;
    }
    
    let count = 1, runner = head;
    while (count < k) {
        runner = runner.next;
        count++;
    }
    
    let current = head, prev = null;
    while (runner.next) {
        prev = current;
        current = current.next;
        runner = runner.next;
    }
    runner.next = head;
    prev.next = null;
    
    return current;
};