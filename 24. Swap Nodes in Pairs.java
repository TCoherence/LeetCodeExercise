/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if ( head == null ) return null;
        ListNode Head = new ListNode(0);
        Head.next = head;
        if ( head.next == null ) return head;
        swap(Head, head, head.next);
        return Head.next;
    }
    public void swap(ListNode head, ListNode node1, ListNode node2){
        node1.next= node2.next;
        node2.next = node1;
        head.next = node2;
        if ( node1.next == null || node1.next.next == null ) return;
        swap(node1, node1.next, node1.next.next);
    }
}
