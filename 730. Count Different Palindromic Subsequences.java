class Solution {
    private final int MOD = 1000000007;
    public int countPalindromicSubsequences(String S) {
        if ( S == null ) return 0;
        int[][] dp = new int[S.length()][S.length()];
        int[] leftNext = new int[S.length()]; // the first same char of s.charAt(i) in its left
        int[] rightNext= new int[S.length()]; // the first same char of s.charAt(i) in its right
        int[] record = new int[]{-1, -1, -1, -1};
        // param initializing
        for ( int i = 0; i < S.length(); i++ ) {
            dp[i][i] = 1;
        }
        for ( int i = 0; i < S.length(); i++ ) {
            leftNext[i] = record[S.charAt(i) - 'a'];
            record[S.charAt(i) -'a'] = i;
        }
        for ( int i = S.length() - 1; i >= 0; i-- ) {
            rightNext[i] = record[S.charAt(i) - 'a'];
            record[S.charAt(i) - 'a'] = i;
        }
        
        // dp solution
        for ( int i = S.length() - 1 ; i >= 0; i--) {
            for ( int j = i + 1; j < S.length(); j++ ) {
                if ( S.charAt(i) != S.charAt(j) ) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
                else {
                    int irn = rightNext[i];
                    int jln = leftNext[j];
                    if ( irn == j ) {
                        dp[i][j] = (dp[i + 1][j - 1]) * 2 + 2;
                    }
                    else if ( irn == jln ) {
                        dp[i][j] = (dp[i + 1][j - 1]) * 2 + 1;
                    }
                    else {
                        dp[i][j] = (dp[i + 1][j - 1]) * 2 - dp[irn + 1][jln - 1];
                    }
                }
                dp[i][j] %= MOD;
                if ( dp[i][j] < 0 ) dp[i][j] += MOD;
            }
        }
        return dp[0][S.length() - 1];
        
    }
}
