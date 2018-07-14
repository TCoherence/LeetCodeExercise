class Solution {
    public int islandPerimeter(int[][] grid) {
        // check para
        if ( grid == null || grid.length == 0 || grid[0].length == 0 ) return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        for ( int i = 0; i < row; i++ ) {
            for ( int j = 0; j < col; j++ ) {
                if ( grid[i][j] == 1 ){
                    return helper(grid, i, j);
                }
            }
        }
        return 0;
    }
    
    private int helper(int[][] grid, int i, int j){
        grid[i][j] = 2;
        int cnt = 0;
        if ( isValid(i + 1, j, grid.length, grid[0].length) && grid[i + 1][j] == 1 ) 
            cnt += helper(grid, i + 1, j);
        else if ( isValid(i + 1, j, grid.length, grid[0].length) && grid[i + 1][j] == 2 ) {
        }            
        else 
            cnt++;
        if ( isValid(i - 1, j, grid.length, grid[0].length) && grid[i - 1][j] == 1 ) 
            cnt += helper(grid, i - 1, j);
        else if ( isValid(i - 1, j, grid.length, grid[0].length) && grid[i - 1][j] == 2 ) {
            
        }
        else
            cnt++;
        if ( isValid(i, j + 1, grid.length, grid[0].length) && grid[i][j + 1] == 1 ) 
            cnt += helper(grid, i, j + 1);
        else if ( isValid(i, j + 1, grid.length, grid[0].length) && grid[i][j + 1] == 2 ) {
            
        }
        else 
            cnt++;        
        if ( isValid(i, j - 1, grid.length, grid[0].length) && grid[i][j - 1] == 1 )
            cnt += helper(grid, i, j - 1);
        else if ( isValid(i, j - 1, grid.length, grid[0].length) && grid[i][j - 1] == 2 ) {
            
        }
        else 
            cnt++;
        // grid[i][j] = 1;
        return cnt;
    }
    
    private boolean isValid(int i, int j, int row, int col) {
        if ( i < 0 || i >= row || j < 0 || j >= col ) 
            return false;
        else 
            return true;
    }
}

// solutioin 2, more concise and fewer stack consumation
class Solution {
    public int islandPerimeter(int[][] grid) {
        // check para
        if ( grid == null || grid.length == 0 || grid[0].length == 0 ) return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        int primeter = 0;
        for ( int i = 0;i < row; i++ ) {
            for ( int j = 0; j < col; j++ ) {
                if ( grid[i][j] == 1 ){
                    primeter += 4;
                    if ( i > 0 && grid[i - 1][j] == 1 ) 
                        primeter--;
                    if ( i < row - 1 && grid[i + 1][j] == 1 ) 
                        primeter--;
                    if ( j > 0 && grid[i][j - 1] == 1 ) 
                        primeter--;
                    if ( j < col - 1 && grid[i][j + 1] == 1 ) 
                        primeter--;
                }
            }
        }
        return primeter;
    }
}

