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
    public int sumOfLeftLeaves(TreeNode root) {
        if ( root == null ) return 0;
        else return sumOfLeftLeaves(root.right, false) + sumOfLeftLeaves(root.left, true);
    }
    public int sumOfLeftLeaves(TreeNode root, boolean isLeft){
        if ( root == null ) return 0;
        int count = 0;
        if ( root.left == null && root.right == null ) {
            if ( isLeft ) return root.val;
            return 0;
        }
        if ( root.left != null )  count += sumOfLeftLeaves(root.left, true);
        if ( root.right != null ) count += sumOfLeftLeaves(root.right, false);
        return count;
    }
}
