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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        if ( root == null ) return res;
        stack1.push(root);
        while( !stack1.empty() || !stack2.empty() ){
            TreeNode tmp;
            while ( !stack1.empty() ){
                tmp = stack1.pop();
                if ( tmp.left  != null ) stack2.push(tmp.left);
                if ( tmp.right != null ) stack2.push(tmp.right);
                list.add(tmp.val);
            }
            if ( !list.isEmpty() ){
                res.add(list);
                list = new ArrayList<>();
            }
            
            
            while ( !stack2.empty() ){
                tmp = stack2.pop();
                if ( tmp.right != null ) stack1.push(tmp.right);
                if ( tmp.left  != null ) stack1.push(tmp.left);
                list.add(tmp.val);
            }
            if ( !list.isEmpty() ){
                res.add(list);
                list = new ArrayList<>();
            }
        }
        return res;
    }
}
