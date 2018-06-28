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
    public TreeNode sortedArrayToBST(int[] nums) {
        if ( nums == null || nums.length == 0 ) return null;
        return bstHelper(nums, 0, nums.length - 1);
    
    }
    public TreeNode bstHelper(int[] nums, int start, int end){
        // find the mid and split the array into 2 subarrays and recursively do the same
        if ( end <  start ) return null;
        if ( end == start ) return new TreeNode(nums[end]);
        // find the midium
        int mid = start + (end - start + 1) / 2;  
        TreeNode root = new TreeNode(nums[mid]);
        root.left  = bstHelper(nums, start, mid - 1);
        root.right = bstHelper(nums, mid + 1, end);
        return root;
    }
}
