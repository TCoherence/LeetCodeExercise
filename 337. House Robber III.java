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
    public int rob(TreeNode root) {
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);
        
    }
    public int[] robHelper(TreeNode root) {
        if ( root == null ) return new int[2];
        
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);
        int[] res = new int[2];
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[1], left[0]) + Math.max(right[1], right[0]);
        return res;
    }
    
        
        
    
    // First I think this too simple, I think the house is robbed definitely one by one, but not.
    // AC but it seems that time performance is too bad...
    // apparently there are overlapping subproblems, for every node we need to decide take it or not, so take root as an example,
    // whether root.left.child are taken depends on two condition, whether root is taken and whether root.left is taken. So this causes
    // overlapping.
}
