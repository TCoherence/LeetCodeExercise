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
        if ( head == null ) return false;
        if ( head.next == null || head.next.next == null ) return false;
        ListNode walker = head.next;
        ListNode runner = head.next.next;
        while( runner.next != null && runner.next.next != null ){
            if( walker == runner) return true;
            else {
                walker = walker.next;
                runner = runner.next.next;
            }
        }
        return false;
    }
}
