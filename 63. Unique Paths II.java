class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if ( obstacleGrid == null || obstacleGrid.length == 0 ) return 0;
        if ( obstacleGrid[0].length == 0 ) return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] dp = new int[col];
        dp[0] = 1;
        for (int i = 0; i < row;i++){
            for (int j = 0; j < col;j++){
                if (obstacleGrid[i][j] == 1) dp[j] = 0;
                else if ( j != 0 ) dp[j] = dp[j] + dp[j - 1];
                
            }
        }
        return dp[col - 1];
    }
}
