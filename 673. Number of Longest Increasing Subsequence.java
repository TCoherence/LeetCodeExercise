class Solution {
    public int findNumberOfLIS(int[] nums) {
        // check param
        if ( nums == null || nums.length == 0 ) return 0;
        
        int[] dp  = new int[nums.length];
        int[] cnt = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        // dp and count
        for ( int i = 0; i < nums.length; i++ ) {
            for ( int j = 0; j < i; j++ ) {
                if ( nums[i] > nums[j] ) {
                    if ( dp[i] == dp[j] + 1 ) cnt[i] += cnt[j];
                    if ( dp[i] < dp[j] + 1 ) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                        max = Math.max(max, dp[i]);
                    }
                }
            }
        }
        // find res
        int res = 0;
        for ( int i = 0; i < nums.length; i++ ) {
            if ( dp[i] == max ) 
                res += cnt[i];
        }
        // return
        return res;
    }
}
