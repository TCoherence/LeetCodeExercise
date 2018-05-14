class Solution {
    private int row, col;
    public int maxAreaOfIsland(int[][] grid) {
        if ( grid == null || grid.length == 0 ) return 0;
        row = grid.length;
        col = grid[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int max = 0;
        for ( int i = 0; i < row; i++){
            for ( int j = 0; j < col; j++){
                if ( isVisited[i][j] || grid[i][j] == 0 ) continue;
                max = Math.max(max, helper(isVisited, grid, i, j));
            }
        }
        return max;
        
    }
    public int helper(boolean[][] isVisited, int[][] grid, int i, int j) {
        if ( isValid(i,j) && !isVisited[i][j] && grid[i][j] == 1 ){
            isVisited[i][j] = true;
            return  helper(isVisited, grid, i+1,j) + 
                    helper(isVisited, grid, i, j+1) +
                    helper(isVisited, grid, i, j-1) +
                    helper(isVisited, grid, i-1, j) + 1;
        }
        else return 0;
    }
    public boolean isValid(int i, int j){
        if ( i >= 0 && i < row && j >=0 && j < col ) return true;
        else return false;
    }
    
}
