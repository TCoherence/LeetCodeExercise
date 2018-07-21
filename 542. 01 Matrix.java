// Stupid Solution one to go dfs of everynode. it will become the worst when there is a very long connected nodeline.
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        // check param
        if ( matrix == null || matrix.length == 0 || matrix[0].length == 0 ) return matrix;
        
        int row = matrix.length;
        int col = matrix[0].length;
        for ( int i = 0; i < row; i++ ) {
            for ( int j = 0; j < col; j++ ) {
                if ( matrix[i][j] != 0 ) {
                    matrix[i][j] = dfs(matrix, i, j, 0, row + col - 1);
                }
            }
        }
        return matrix;
    }
    public int dfs(int[][] matrix, int i, int j, int depth, int maxDepth) {
        if ( matrix[i][j] == 0 || depth >= maxDepth ) return depth;
        int cnt = Integer.MAX_VALUE;
        int tmp = matrix[i][j];
        matrix[i][j] = -1;
        if ( i > 0 && matrix[i - 1][j] >= 0) 
            cnt = Math.min(cnt, dfs(matrix, i - 1, j, depth + 1, maxDepth) );
        maxDepth = cnt;
        if ( i < matrix.length - 1 && matrix[i + 1][j] >= 0 ) 
            cnt = Math.min(cnt, dfs(matrix, i + 1, j, depth + 1, maxDepth) );
        maxDepth = cnt;
        if ( j > 0 && matrix[i][j - 1] >= 0 ) 
            cnt = Math.min(cnt, dfs(matrix, i, j - 1, depth + 1, maxDepth) );
        maxDepth = cnt;
        if ( j < matrix[0].length - 1 && matrix[i][j + 1] >= 0 ) 
            cnt = Math.min(cnt, dfs(matrix, i, j + 1, depth + 1, maxDepth) );
        matrix[i][j] = tmp;
        return cnt;
    }
}
// This solution will have a better performance because it takes advantage of bfs and bfs from 0's not 1's.
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        // check param
        // we do not need bfs from 1 to 0, we can 0 to 1, still keep the path distance is shortest.
        // First we only update nodes surrounding 0 and mark the 0 as visited, then we update these nodes
        // to their surroundings.
        if ( matrix == null || matrix.length == 0 || matrix[0].length == 0 ) return matrix;
        
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] isVisited = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();
        for ( int i = 0; i < row; i++ ) {
            for ( int j = 0; j < col; j++ ) {
                if ( matrix[i][j] == 0 ) {
                    isVisited[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[][] paths = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while ( !q.isEmpty() ) {
            int[] point = q.poll();
            for ( int[] path : paths ) {
                int i = point[0] + path[0];
                int j = point[1] + path[1];
                if ( i < 0 || i >= row || j < 0 || j >= col || isVisited[i][j] )
                    continue;
                isVisited[i][j] = true;
                matrix[i][j] = matrix[point[0]][point[1]] + 1;
                q.offer(new int[]{i, j});
            }
        }
        return matrix;
        
    }
    
}
