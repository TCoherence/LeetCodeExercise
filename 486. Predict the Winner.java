class Solution {
    public boolean PredictTheWinner(int[] nums) {
        // check para
        if ( nums == null || nums.length == 0 ) return false;
        if ( nums.length == 1 ) return true;
        if ( (nums.length & 1) == 0 ) return true;
        // 
        int[][] dp = new int[nums.length][nums.length];
        for ( int i = 0; i < nums.length; i++ ) {
            dp[i][i] = nums[i];
        }
        for ( int len = 1; len < nums.length; len++ ) {
            for ( int i = 0; i < nums.length - len; i++ ) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        // return
        return dp[0][nums.length - 1] >= 0;
    }

}

// I am not able to work this out which is really frastrated...
