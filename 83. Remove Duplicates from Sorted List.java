/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode tail = head;
        while( tail != null ) {
            if ( tail.next == null ) break;
            if ( tail.next.val == tail.val ) {
                if (tail.next.next ==  null) tail.next = null;
                else tail.next = tail.next.next;
            }
            else{
                tail = tail.next;
            }
        }
        return head;
    }
}
