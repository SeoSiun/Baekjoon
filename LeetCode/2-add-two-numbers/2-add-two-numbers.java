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

// 서시언
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        int carry = 0;
        int add;
        
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        int l1Len = getLength(l1);
        int l2Len = getLength(l2);

         while (l1Len > 0 && l2Len > 0) {
             add = popLast(l1) + popLast(l2) + carry;
             carry = add / 10;
             result = addLast(result, add % 10);
             l1Len--;
             l2Len--;
         }
        while (l1Len > 0) {
            add = popLast(l1) + carry;
            carry = add / 10;
            result = addLast(result, add % 10);
            l1Len--;
        }
        while (l2Len > 0l){
            add = popLast(l2) + carry;
            carry = add / 10;
            result = addLast(result, add % 10);
            l2Len--;
        }
        if (carry != 0)
            result = addLast(result, carry);
        return result;
    }
    
    private ListNode reverse(ListNode list) {
        ListNode prev = null;
        ListNode tmp = list;
        ListNode next;
        
        while (tmp != null) {
            next = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = next;
        }
        return prev;
    }
    
    private int popLast(ListNode list) {
        ListNode iter = list;
        int result;
        
        if (iter.next == null) {
            result = iter.val;
            return result;
        }
        while (iter.next.next != null) {
            iter = iter.next;
        }
        result = iter.next.val;
        iter.next = null;
        return result;
    }
    
    private int getLength(ListNode list) {
        ListNode iter = list;
        int len = 0;
        while (iter != null) {
            iter = iter.next;
            len++;
        }
        return (len);
    }
    
    private ListNode addLast(ListNode list, int val) {
        ListNode iter = list;
        
        if (list == null) {
            return new ListNode(val, null);
        }
        while (iter.next != null) {
            iter = iter.next;
        }
        iter.next = new ListNode(val, null);
        return list;
    }
}