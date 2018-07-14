class Solution {
    public boolean isMatch(String s, String p) {
        // check para
        if ( s == null || p == null || s.equals(null) || p.equals(null) ) return false;
        
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        
        // initialize 
        dp[0][0] = true;
        for ( int i = 0; i < p.length(); i++ ) {
            if ( p.charAt(i) == '*' && dp[0][i - 1] ) 
                dp[0][i + 1] = true;
        }
        
        for ( int i = 0; i < s.length(); i++ ) {
            for ( int j = 0; j < p.length(); j++ ) {
                if ( p.charAt(j) == '.' )
                    dp[i + 1][j + 1] = dp[i][j];
                else if (p.charAt(j) == s.charAt(i) )
                    dp[i + 1][j + 1] = dp[i][j];
                else if (p.charAt(j) == '*' ) {
                    // two conditions:
                    // 1. p.charAt(j - 1) != s.charAt(i) && p.charAt(j) != '.'  -----> we can only empty this
                    // 2. three conditions to consider:
                    //      a) dp[i + 1][j + 1] = dp[i][j + 1], i = i + 1 - 1 means that we can repeat multiple times
                    //      b) dp[i + 1][j + 1] = dp[i + 1][j], j = j + 1 - 1 means that we only take only one time
                    //      c) dp[i + 1][j + 1] = dp[i + 1][j - 1], which means we will empty this
                    if ( p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.' )
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    else
                        dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1];
                }
            }
        }
        
        // return
        return dp[s.length()][p.length()];
    }
}
