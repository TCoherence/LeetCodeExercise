class Solution {
    public int pivotIndex(int[] nums) {
        // check para
        if ( nums == null || nums.length == 0 ) return -1;
        
        int len = nums.length;
        int sum = 0;
        for ( int i = 0; i < len; i++ ) {
            sum += nums[i];
        }
        
        int left = 0;
        for ( int i = 0; i < len; i++ ) {
            if ( sum == 2 * left + nums[i] ) return i;
            left += nums[i];
        }
        return -1;
    }
}
