/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
            if (cnt > 10000)
                return true;
        }
        return false;
    }
}