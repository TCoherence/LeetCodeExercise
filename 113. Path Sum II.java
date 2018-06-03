/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Two points to keep in mind:
 * 1. res.add(new ArrayList(list)); if not use new operation, the content in res will change as list change.
 * 2. read the requirements carefully, it contains not only positive number.
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if ( root == null ) return res;
        pathSum(root, sum, 0, res, list);
        return res;
        
    }
    public void pathSum(TreeNode root, int target, int sum, List<List<Integer>> res, List<Integer> list){
        
        list.add(root.val);
        sum += root.val;
        // if ( sum > target ) {
        //     list.remove(list.size() - 1);
        //     return;
        // }
        // reached the leaf
        if ( root.left == null && root.right == null ) {
            if ( sum == target ){
                res.add(new ArrayList(list)); // remember to new 
            }
        }
        if ( root.left != null ) {
            pathSum( root.left, target, sum, res, list);
        }
        if ( root.right != null ) {
            pathSum( root.right, target, sum, res, list);
        }
        list.remove(list.size() - 1);

            
    }
}
