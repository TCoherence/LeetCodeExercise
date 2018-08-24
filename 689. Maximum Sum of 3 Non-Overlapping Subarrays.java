class Solution {
    private final int  NUM = 3;
    

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[][] dp = new int[NUM][nums.length];
        int     max = 0;
        int[]   res = new int[NUM];
        int[] m = new int[NUM];
        for ( int col = nums.length - k; col >= (NUM-1)*k; col-- ) {
            for ( int layer = 0, c = col; layer < NUM; layer++, c = c - k ) {
                if ( layer == 0 ) {
                    dp[layer][c] = acc(nums, c, k);
                    m[layer] = Math.max(m[layer], acc(nums, c, k));
                }
                else {
                    dp[layer][c] = m[layer - 1] + acc(nums, c, k);
                    m[layer] = Math.max(m[layer], dp[layer][c]);
                }
            }
        }

        max = findMax(dp[NUM - 1]);
        int i = 0;
        // // print test
        // for ( int idx = 0; idx < NUM; idx++ ) {
        //     int[] memo = dp[idx];
        //     System.out.printf("memo %d : idx = %s, m = %d\n", idx, Arrays.toString(memo), m[idx]);
        // }
        // //
        for ( int idx = NUM - 1; idx >= 0; idx-- ) {
            int[] memo = dp[idx];
            // System.out.printf("memo %d : idx = %s\n", idx, Arrays.toString(memo));
            while ( memo[i] != max ) {
                i++;
            }
            res[NUM - idx - 1] = i;
            max = max - acc(nums, i, k);
            i = i + k;
        }
        
        return res;
    }
    private int findMax(int[] dp) {
        int max = 0;
        for (int m : dp) {
            max = Math.max(m, max);
        }
        return max;
    }
    private int acc(int[] nums, int c, int k) {
        int res = 0;
        for ( int i = 0; i < k; i++ ) {
            res += nums[c + i];
        }
        return res;
    }
}
