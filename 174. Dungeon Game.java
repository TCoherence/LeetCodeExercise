class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        // check param
        if ( dungeon == null || dungeon.length == 0 || dungeon[0].length == 0 ) return -1;
        
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[] dp = new int[col];
        
        
        
        // buttom level
        for ( int j = col - 1; j >= 0; j-- ) {
            if ( j == col - 1 )
                dp[j] = dungeon[row - 1][col - 1];
            else{
                dp[j] = dp[j + 1] + dungeon[row - 1][j];
            }
            if ( dp[j] > 0 ) 
                dp[j] = 0;
        }
         System.out.printf("dp = %s\n", Arrays.toString(dp));
        
        // last but one level
        for ( int i = row - 2; i >= 0; i-- ) {
            
            for ( int j = col - 1; j >= 0; j-- ) {
                if ( j == col - 1 ) {
                    dp[j] = dp[j] + dungeon[i][j];
                }
                else {
                    dp[j] = Math.max(dp[j], dp[j + 1]) + dungeon[i][j];
                }
                if ( dp[j] > 0 ) 
                    dp[j] = 0;
            }
        }
        return 1 - dp[0];
    }
}
