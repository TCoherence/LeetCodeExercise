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
    private int globalMax = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        int tmp = maxRet(root);
        return globalMax;
    }
    
    public int maxRet(TreeNode root) {
        // hit the ground
        if ( root.left == null && root.right == null ) {
            globalMax = Math.max(globalMax, root.val);
            // if >= ret to the up node, otherwise ret 0, which means do not ret a value.
            return root.val > 0 ? root.val : 0;
        }
        // haven't hit the bottom yet
        int leftMax = 0, rightMax = 0;
        if ( root.left != null ) leftMax = maxRet(root.left);
        if ( root.right != null ) rightMax = maxRet(root.right);
        int value = root.val;
        if ( leftMax > 0 ) value += leftMax;
        if ( rightMax > 0 ) value += rightMax;
        globalMax = Math.max(globalMax, value);
        value = root.val + Math.max( leftMax, rightMax );
        value = Math.max( root.val, value );
        globalMax = Math.max(globalMax, value);
        
        return value > 0 ? value : 0;
        
    }
}
