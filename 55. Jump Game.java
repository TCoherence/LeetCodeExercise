class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        int len = nums.length;
        for ( int i = 0; i < len; i++){
            if ( i > max ) return false;
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}

// use max to restore the maximun index can be reached in index i
