/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /* reverse two list, sum, then re-reverse to return the correct result */
        ListNode head1 = reverse(l1);
        ListNode head2 = reverse(l2);
        ListNode head3 = new ListNode(0);
        ListNode head  = head3;
        int c = 0;
        int s = 0;
        while ( head1 != null && head2 != null ) {
            s = head1.val + head2.val + c;
            if ( s >= 10 ) {
                s -= 10;
                c = 1;
            }
            else {
                c = 0;
            }
            head3.next = new ListNode(s);
            head3 = head3.next;
            head1 = head1.next;
            head2 = head2.next;
        }
        while ( head1 != null ) {
            s = head1.val + c;
            if ( s >= 10 ) {
                s -= 10;
                c = 1;
            }
            else {
                c = 0;
            }
            head3.next = new ListNode(s);
            head3 = head3.next;
            head1 = head1.next;
        }
        while ( head2 != null ) {
            s = head2.val + c;
            if ( s >= 10 ) {
                s -= 10;
                c = 1;
            }
            else {
                c = 0;
            }
            head3.next = new ListNode(s);
            head3 = head3.next;
            head2 = head2.next;
        }
        if ( c == 1 ) head3.next = new ListNode(1);
        return reverse(head.next);
    }
    public ListNode reverse(ListNode head) {
        ListNode Head = new ListNode(0);
        while ( head != null ) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = Head.next;
            Head.next = tmp;
        }
        return Head.next;
    }
}
