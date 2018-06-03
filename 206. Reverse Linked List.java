/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if ( head == null || head.next == null ) return head;
        ListNode Head = new ListNode(0);
        Head.next = head;
        head = head.next;
        Head.next.next = null;
        while ( head != null ){
            ListNode tmp = head.next;
            head.next = Head.next;
            Head.next = head;
            head = tmp;
        }
        return Head.next;
    }
}
