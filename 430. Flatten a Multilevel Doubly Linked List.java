/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        Node node = head;
        while ( node != null ) {
            if ( node.child != null ) {
                node = helper(node);
            }
            node = node.next;
        }
        return head;
    }
    public Node helper(Node node) {
        Node parent = node;
        Node child = node.child;
        Node next = node.next;
        parent.next = child;
        parent.child = null;
        child.prev = parent;
        while ( child != null ) {
            if ( child.child != null ) {
                child = helper(child);
            }
            if ( child.next == null ) break;
            child = child.next;
        }
        child.next = next;
        if ( next != null ) next.prev = child;
        return child;
    }
}
