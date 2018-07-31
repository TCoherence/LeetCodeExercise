class Solution {
    public int numDecodings(String s) {
        // dp[i] = dp[i + 1] + dp[i + 2]
        // 5 steps to DP
        if ( s == null ) return 0;
        if ( s.length() == 0 ) return 0;
        if ( s.length() == 1 ) {
            if ( s.charAt(0) == '0' ) return 0;
            else return 1;
        }
        int len = s.length();
        int[] dp = new int[len];
        int first = 0;
        int second = 0;
        dp[len - 1] = s.charAt(len - 1) == '0' ? 0 : 1;
        first = s.charAt(len - 2) - '0';
        second = s.charAt(len - 1) -'0';
        second = first * 10 + second;
        if ( 1 <= first && first <= 9 ) 
            dp[len - 2] += dp[len - 1];
        if ( 10 <= second && second <= 26 ) 
            dp[len - 2] += 1;
        for ( int i = len - 3; i >= 0; i-- ) {
            first = s.charAt(i) - '0';
            second = s.charAt(i + 1) -'0';
            second = first * 10 + second;
            // System.out.printf("first = %d, second = %d\n", first, second);
            if ( 1 <= first && first <= 9 ) 
                dp[i] += dp[i + 1];
            if ( 10 <= second && second <= 26 ) 
                dp[i] += dp[i + 2];
        }
        return dp[0];
    }
    
}

