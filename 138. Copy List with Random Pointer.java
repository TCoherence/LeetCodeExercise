/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if ( head == null ) return head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        // copy nodes
        RandomListNode node = head;
        while ( node != null ) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        // connect copied nodes.
        node = head;
        while ( node != null ) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
        
    }
}

// redo
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if ( head == null ) return head;
        
        // ---- build copied nodes just next to itself ----
        RandomListNode node = head;
        RandomListNode tmp = null;
        while ( node != null ) {
            tmp = new RandomListNode(node.label);
            tmp.next = node.next;
            node.next = tmp;
            node = node.next.next;
        }
        node = head;
        while ( node != null ) {
            tmp = node.next;
            if ( node.random != null ) tmp.random = node.random.next;
            node = node.next.next;
        }
        // delete copied nodes from original list
        node = head;
        RandomListNode ret = head.next;
        while ( node != null ) {
            tmp = node.next;
            node.next = node.next.next;
            if ( tmp.next != null ) tmp.next = tmp.next.next;
            node = node.next;
        }
        return ret;
    }
}
