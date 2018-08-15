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
