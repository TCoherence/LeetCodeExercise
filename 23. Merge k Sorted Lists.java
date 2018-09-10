/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if ( lists == null || lists.length == 0 ) return null;
        return partition(lists, 0, lists.length - 1);
    }
    public ListNode partition(ListNode[] lists, int lo, int hi) {
        if ( lo > hi ) return null;
        if ( lo == hi ) return lists[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode left = partition(lists, lo, mid);
        ListNode right= partition(lists, mid + 1, hi);
        return merge(left, right);
    }
    public ListNode merge(ListNode n1, ListNode n2) {
        ListNode ret = new ListNode(0);
        ListNode res = ret;
        while ( n1 != null || n2 != null ) {
            if ( n1 == null ) {
                ret.next = n2;
                n2 = n2.next;
                ret = ret.next;
            }
            else if ( n2 == null ) {
                ret.next = n1;
                n1 = n1.next;
                ret = ret.next;
            } 
            else if ( n1.val < n2.val ) {
                ret.next = n1;
                n1 = n1.next;
                ret = ret.next;
            }
            else {
                ret.next = n2;
                n2 = n2.next;
                ret = ret.next;
            }
        }
        return res.next;
    }
}
