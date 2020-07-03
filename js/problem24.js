/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
    if ((head === null) || (head.next === null)) {
        return head;
    }
    
    let current = head, prev = null;
    let res = head.next;
    
    while ((current !== null) && (current.next !== null)) {
        let nextPair = current.next.next;
        let temp = current.next;
        temp.next = current;
        current.next = nextPair;
        if (prev !== null) {
            prev.next = temp;
        }
        prev = current;
        current = nextPair;
    }
    
    return res;
    
};