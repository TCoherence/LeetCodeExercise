/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        // check para
        if ( head == null || head.next == null || head.next.next == null ) return ;
        // find mid
        ListNode slow = head;
        ListNode fast = head.next;
        while ( fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the nodes after mid(slow)
        ListNode tail = slow.next;
        while( tail.next != null ){
            fast = tail.next;
            tail.next = tail.next.next;
            fast.next = slow.next;
            slow.next = fast;
        }
        
        // operation
        ListNode pre = head;
        ListNode post = slow.next;
        while(pre != slow ) {
            // splice
            slow.next = post.next;
            post.next = pre.next;
            pre.next  = post;
            // move on
            pre = post.next;
            post = slow.next;
        }
        // done
    }
}
