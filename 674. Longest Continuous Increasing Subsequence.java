class Solution {
    public int findLengthOfLCIS(int[] nums) {
        // check para
        if ( nums == null || nums.length == 0 ) return 0;
        
        int length = nums.length;
        int l = 0, r = 0;
        int maxLen = 1;
        int len = 1;
        for ( int i = 1; i < length; i++ ) {
            if ( nums[i] > nums[i - 1] ) 
                len++;
            else
                len = 1;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
