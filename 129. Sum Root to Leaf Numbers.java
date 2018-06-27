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
    public int sumNumbers(TreeNode root) {
        return sumhelper(root, 0);
    }
    public int sumhelper(TreeNode root, int presum){
        if ( root == null ) return 0;
        int cur = presum * 10 + root.val;
        if ( root.left == null && root.right == null ) return cur;
        int sum = 0;
        sum += sumhelper(root.left, cur);
        sum += sumhelper(root.right,cur);
        return sum;
    }
}
