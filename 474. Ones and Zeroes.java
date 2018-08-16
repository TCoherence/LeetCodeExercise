class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for ( String str : strs ) {
            int num1 = 0, num0 = 0;
            for ( char c : str.toCharArray() ) {
                if ( c == '0' ) num0++;
                else num1++;
            }
            for ( int i = m; i >= num0; i-- ) {
                for ( int j = n; j >= num1; j-- ) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - num0][j - num1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
