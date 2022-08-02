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
        ListNode result = null;
        int len1 = getLength(l1), len2 = getLength(l2);
        int i1 = 0, i2 = 0;
        int carry = 0, add = 0;
        
        while (i1 < len1 && i2 < len2) {
            add = getValueOf(l1, i1) + getValueOf(l2, i2) + carry;
            carry = add / 10;
            result = addLast(result, add % 10);
            i1++;
            i2++;
        }
        while (i1 < len1) {
            add = getValueOf(l1, i1) + carry;
            carry = add / 10;
            result = addLast(result, add % 10);
            i1++;
        }
        while (i2 < len2) {
            add = getValueOf(l2, i2) + carry;
            carry = add / 10;
            result = addLast(result, add % 10);
            i2++;
        }
        if (carry > 0)
            result = addLast(result, carry);
        return result;
    }
    
    public int getValueOf(ListNode list, int index) {
        for(int i = 0; i < index; i++) {
            list = list.next;
        }
        return list.val;
    }
    
    public int getLength(ListNode list) {
        int len = 0;
        
        while (list != null)
        {
            list = list.next;
            len++;
        }
        return len;
    }
    
    private ListNode addLast(ListNode list, int val) {
        ListNode iter = list;
        
        if (list == null)
            return new ListNode(val, null);
        while (iter.next != null)
            iter = iter.next;
        iter.next = new ListNode(val, null);
        return list;
    }
}