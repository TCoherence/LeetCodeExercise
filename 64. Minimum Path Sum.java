class Solution {
    public int minPathSum(int[][] grid) {
        if ( grid == null || grid.length == 0 || grid[0].length == 0 ) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[col];
        dp[0] = grid[0][0];
        for ( int i = 1; i < col; i++ ){
            dp[i] = dp[i - 1] + grid[0][i];
        }
        
        for ( int j = 1; j < row; j++ ){
            dp[0] += grid[j][0];
            for( int i = 1; i < col; i++){
                dp[i] = Math.min(dp[i - 1], dp[i]) + grid[j][i];
            }
        }
        return dp[col - 1];
    }
}
