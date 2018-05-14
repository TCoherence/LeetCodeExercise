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
    public boolean isBalanced(TreeNode root) {
        if ( root == null ) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left - right) > 1 ? false : isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode node){
        if ( node == null ) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.max(left, right) + 1;
    }
}
