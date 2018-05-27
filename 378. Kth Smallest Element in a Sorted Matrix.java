class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if ( matrix == null || matrix.length == 0 || k <= 0 ) return -1;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        int n = matrix.length;
        for ( int i = 0; i < n; i++ )  
            pq.offer(new Tuple(i, 0, matrix[i][0]));
        for ( int j = 0; j < k-1; j++ ){
            Tuple out = pq.poll();
            if ( out.col == n - 1 ) continue;
            pq.offer( new Tuple(out.row, out.col + 1, matrix[out.row][out.col + 1]));
        }
        return pq.poll().val;
        
    }
    private class Tuple implements Comparable<Tuple>{
        int row, col;
        int val;
        public Tuple(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
        
        @Override
        public int compareTo(Tuple that){
            return this.val - that.val;
        }
    }
}

// new class learned and need to be reviewd -- Priority Queue.
// Princeton's algs need to be retake and reviewd
