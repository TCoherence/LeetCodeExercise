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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // easy O(N^2) solution, but is there a better way to solve it? like O(NlogN)
        Stack<TreeNode> stack = new Stack<>();
        for ( int num : nums ) {
            TreeNode cur = new TreeNode(num);
            while ( !stack.isEmpty() && stack.peek().val < num ) {
                cur.left = stack.pop();
            }
            if ( !stack.isEmpty() ) {
                stack.peek().right = cur;
            }
            stack.push(cur);
        }
        if ( stack.size() == 0 ) return null;
        while ( stack.size() > 1 ) 
            stack.pop();
        return stack.peek();
    }
}
