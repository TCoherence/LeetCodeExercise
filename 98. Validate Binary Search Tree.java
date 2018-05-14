/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if ( root == null ) return true;
        // preorder traversal
        Stack<Integer> stack = new Stack<>();
        return preorder(root, stack);
    }
    
    public boolean preorder(TreeNode root, Stack<Integer> stack){
        boolean ret = true;
        if ( root.left != null ){
            ret = ret && preorder(root.left, stack);
        }
        if ( stack.isEmpty() || stack.peek() < root.val ) stack.push(root.val);
        else return false;
        if ( root.right != null ){
            ret = ret && preorder(root.right, stack);
        }
        return ret;
    }
}

// localmin and localmax to restrict the range of node's value
// use two boolean variable to avoid use Long.MIN_VALUE and Lone.MAX_VALUE;
class Solution {
    public boolean isValidBST(TreeNode root) {
        if ( root == null ) return true;
        // the first value of local min and max in the second method of isValidBST can be any because both hasMin and hasMax is false
        return isValidBST(root, 0, 0, false, false);
    }
    
    public boolean isValidBST(TreeNode node, int min, int max, boolean hasMin, boolean hasMax){
        if ( node == null ) return true;
        if ( (hasMin && node.val <= min) || (hasMax && node.val >= max) ) return false;
        return isValidBST(node.left, min, node.val, hasMin, true ) && isValidBST(node.right, node.val, max, true, hasMax);
    }
}
