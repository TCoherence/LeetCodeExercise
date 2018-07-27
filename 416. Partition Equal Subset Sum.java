class Solution {
    public boolean canPartition(int[] nums) {
        // check param
        if ( nums == null || nums.length == 0 ) return false;
        
        int sum = 0;
        for ( int i = 0; i < nums.length; i++ ) {
            sum += nums[i];
        }
        if ( (sum & 1) == 1 ) return false;
        sum = sum/2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for ( int num : nums ) {
            for ( int i = sum; i >= 0; i-- ) {
                if ( i - num >= 0 ) 
                    dp[i] = dp[i - num] || dp[i];
            }
        }
        return dp[sum];
        
    }
}
