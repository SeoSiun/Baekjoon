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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                result = insertLast(result, list1.val);
                list1 = list1.next;
            }
            else {
                result = insertLast(result, list2.val);
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            result = insertLast(result, list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            result = insertLast(result, list2.val);
            list2 = list2.next;
        }
        return result;
    }
    
    private ListNode insertLast(ListNode head, int toInsert) {
        if (head == null) {
            return new ListNode(toInsert, null);
        }
        else {
            ListNode tmp = head;
            while (tmp.next != null)
                tmp = tmp.next;
            tmp.next = new ListNode(toInsert, null);
            
        }
        return head;
    }

}