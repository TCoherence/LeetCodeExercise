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
    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        treePush(stack, root);
        int cnt = 0;
        while ( !stack.isEmpty() ) {
            cnt += stack.peek().val;
            stack.pop().val = cnt;
        }
        return root;
    }
    public void treePush(Stack<TreeNode> stack, TreeNode node) {
        if ( node == null ) return;
        treePush(stack, node.left);
        stack.push(node);
        treePush(stack, node.right);
    }
}
