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


let reverseGroup = function(start, end) {
    
    if (start === end) {
        return;
    }
    
    let current = start, prev = null;
    while (current !== end) {
        let nextNode = current.next;
        current.next = prev;
        prev = current;
        current = nextNode;
    }
    end.next = prev;
};


var reverseKGroup = function(head, k) {
    if ((head === null) || (head.next === null) || (k === 1)) {
        return head;
    }
    
    let res = null;
    let current = head, prev = null;
    
    while (current !== null) {
        let runner = current, count = 1;
        while (count < k) {
            runner = runner.next;
            count++;
            if (runner === null) {
                if (res) {
                    prev.next = current;
                    return res;
                }
                return head;
            }
        }
        
        let nextGroup = runner.next;
        reverseGroup(current, runner);
        if (prev) {
            prev.next = runner;
        }
        prev = current;
        if (!res) {
            res = runner;
        }
        current = nextGroup;
    }
    
    return res;
    
};