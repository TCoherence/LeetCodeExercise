/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        // check para
        if ( head == null || head.next == null || head.next.next == null ) return head;
        
        // build 2 ListNode slow and fast
        ListNode slow = head;
        ListNode fast = head.next;
        
        // in while, find every even node and put it into the required place.
        while( fast != null && fast.next != null ) {
            ListNode odd = fast.next;
            fast.next = fast.next.next;
            odd.next = slow.next;
            slow.next = odd;
            slow = slow.next;
            fast = fast.next;
        }
        return head;
    }
    
}
