/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if ( head == null ) return head;
        ListNode tail = head;
        while ( tail.next != null ) tail = tail.next;
        return sortList(head, tail);
    }
    public ListNode sortList(ListNode head, ListNode tail){ 
    
    // tail is not necessary if we do not need to keep original structure. 
    // It is always no need to keep original sequence of sth if we want to reorganize it.....
        // check para
        if ( head == tail ) return new ListNode(head.val);
        // div into 2 sublist, start at head, stop at (int) (len + 1)-th
        ListNode slow = head;
        ListNode fast = head;
        while ( fast.next != tail && fast.next.next != tail ){
            slow = slow.next;
            fast = fast.next.next;
        }
        // sort sublist
        ListNode left  = sortList(head, slow);
        ListNode right = sortList(slow.next, tail);
        // merge sublist
        ListNode headNew = mergeList(new ListNode(0), left, right);
        // return
        return headNew;
    }
    public ListNode mergeList(ListNode headNew, ListNode headOne, ListNode headTwo ){
        ListNode head1 = headOne;
        ListNode head2 = headTwo;
        ListNode head  = headNew;
        while( head1 != null || head2 != null ){
            if ( head1 == null ) {
                head.next = new ListNode(head2.val);
                head = head.next;
                head2 = head2.next;
            }
            else if ( head2 == null ) {
                head.next = new ListNode(head1.val);
                head = head.next;
                head1 = head1.next;
            }
            else if ( head1.val > head2.val ){
                head.next = new ListNode(head2.val);
                head = head.next;
                head2 = head2.next;
            }
            else{
                head.next = new ListNode(head1.val);
                head = head.next;
                head1 = head1.next;
            }
        }
        return headNew.next;
    }
}
