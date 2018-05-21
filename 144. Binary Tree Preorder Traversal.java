/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// iterative solution
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if ( root == null ) return res;
        res.add(root.val);
        stack.push(root.right);
        stack.push(root.left);
        while(!stack.isEmpty()){
            root = stack.pop();
            if ( root == null ) continue;
            res.add(root.val);
            stack.push(root.right);
            stack.push(root.left);
        }
        return res;
    }
    
    
}
