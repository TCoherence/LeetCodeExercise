class Solution {
    private class Node {
        private int val;
        private int x,y;
        Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if ( heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2 ) return 0;
        PriorityQueue<Node>  pq = new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node a, Node b) {
                return a.val - b.val;
            }
        });
        boolean[][]             visited = new boolean[heightMap.length][heightMap[0].length];
        int[][]                 height = heightMap;
        int                     row = height.length;
        int                     col = height[0].length;
        int                     sum = 0;
        int                     max = 0;
        
        // push boundry  
        for ( int c = 0; c < col; c++ ) {
            pq.offer(new Node(height[0][c], 0, c));
            pq.offer(new Node(height[row - 1][c], row - 1, c));
            visited[0][c] = true;
            visited[row - 1][c] = true;
        }
        for ( int r = 1; r < row - 1; r++ ) {
            pq.offer(new Node(height[r][0], r, 0));
            pq.offer(new Node(height[r][col - 1], r, col - 1));
            visited[r][0] = true;
            visited[r][col - 1] = true;
        }
        while ( !pq.isEmpty() ) {
            Node node = pq.poll();
            if ( node.val < max ) 
                sum += max - node.val;
            else 
                max = node.val;
            //pushNeighber(node, pq, visited);
            int r = node.x, c = node.y;
            if ( c > 0 && !visited[r][c - 1]) {
                pq.offer(new Node(height[r][c - 1], r, c - 1));
                visited[r][c - 1] = true;
            }
            if ( c < col - 1 && !visited[r][c + 1] ) {
                pq.offer(new Node(height[r][c + 1], r, c + 1));
                visited[r][c + 1] = true;
            }
            if ( r > 0 && !visited[r - 1][c] ) {
                pq.offer(new Node(height[r - 1][c], r - 1, c));
                visited[r - 1][c] = true;
            }
            if ( r < row - 1 && !visited[r + 1][c] ) {
                pq.offer(new Node(height[r + 1][c], r + 1, c));
                visited[r + 1][c] = true;
            }
        }
        return sum;
        
    }
    
}
