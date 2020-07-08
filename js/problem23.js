/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */

function mergeTwoLists(l1, l2) {
    if (l1 === null) {
        return l2;
    } else if (l2 === null) {
        return l1;
    }
    
    let head = null, tail = null;
    
    while ((l1 !== null) && (l2 !== null)) {
        let newNode = l1;
        if (l2.val < l1.val) {
            newNode = l2;
            l2 = l2.next;
        } else {
            l1 = l1.next;
        }
        
        if (head === null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    if (l1 !== null) {
        tail.next = l1;
    } else if (l2 !== null) {
        tail.next = l2;
    }
    
    return head;
}

var mergeKLists = function(lists) {
    if (lists.length === 0) {
        return null;
    } else if (lists.length === 1) {
        return lists[0];
    }
    
    while (lists.length > 1) {
        let tempList = [];
        for (let i = 0; i < lists.length; i = i + 2) {
            if (i === lists.length - 1) {
                tempList.push(lists[i]);
                break;
            }
            
            let tempMergedList = mergeTwoLists(lists[i], lists[i + 1]);
            tempList.push(tempMergedList);
        }
        
        lists = tempList;
    }
    
    return lists[0];
};