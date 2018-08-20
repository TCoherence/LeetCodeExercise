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
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        int tmp = helper(root);
        // System.out.printf("tmp = %d\n", tmp);
        max = Math.max(max, tmp - 1);
        return max;
    }
    public int helper(TreeNode node) {
        if ( node == null ) return 0;
        int left  = helper(node.left);
        int right = helper(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
