class Solution {
    public int maxSubArray(int[] nums) {
        if ( nums == null || nums.length == 0 ) return Integer.MIN_VALUE;
        int len = nums.length;
        int maxsum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < len; i++){
            sum += nums[i];
            maxsum = Math.max( sum, maxsum );
            if( sum < 0 ) sum = 0;
        }
        return maxsum;
    }
}
