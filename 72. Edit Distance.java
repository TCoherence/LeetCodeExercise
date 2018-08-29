class Solution {
    public int minDistance(String word1, String word2) {
        if ( word1 == null || word2 == null ) return 0;
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // initializing
        for ( int i = 0; i <= word1.length(); i++ ) {
            dp[i][0] = i;
        }
        for ( int i = 0; i <= word2.length(); i++ ) {
            dp[0][i] = i;
        }
        for ( int i = 0; i < word1.length(); i++ ) {
            for ( int j = 0; j < word2.length(); j++ ) {
                if ( word1.charAt(i) == word2.charAt(j) ) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                else {
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;
                    int replace= dp[i][j] + 1;
                    dp[i + 1][j + 1] = Math.min(Math.min(insert, delete), replace);

                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
