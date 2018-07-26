class Solution {
    private int[] parent;
    private int[] size;
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        // check param
        if ( edges == null || edges.length == 0 || edges[0].length == 0 ) return null;
        
        int[] c1 = new int[]{-1, -1};
        int[] c2 = new int[]{-1, -1};
        parent = new int[edges.length + 1];
        size = new int[edges.length + 1];
        // initial
        for ( int i = 0; i < edges.length + 1; i++ ) {
            parent[i] = i;
            size[i] = 1;
        }
        // find possible edge : double-root or loop
        for ( int[] edge : edges ) {
            int i = rootOf(edge[0]);
            int j = rootOf(edge[1]);
            // first case : loop --> same root
            if ( i == j ) {
                
            }
            // second case : double root, the child has two root, which means the child is not the root of itself.
            else if ( j != edge[1] ) {
                c1[0] = parent[edge[1]];
                c1[1] = edge[1];
                c2[0] = edge[0];
                c2[1] = edge[1];
                // disable the second edge
                edge[0] = 0;
            }
            else {
                parent[edge[1]] = edge[0];
            }
            
        }
        
        // normal union find.
        // Re-initial
        for ( int i = 0; i < edges.length + 1; i++ ) {
            parent[i] = i;
            size[i] = 1;
        }
        
        for ( int[] edge : edges ) {
            if ( edge[0] == 0 ) continue;
            int i = rootOf(edge[0]);
            int j = rootOf(edge[1]);
            // first case : loop 
            if ( i == j ) {
                if ( c1[0] == -1 ) {
                    return edge;
                }
                else {
                    return c1;
                }
            }
            // second case : double root, because of former operation, no doubleroot exists.
            parent[edge[1]] = edge[0];
            size[i] += size[j];
        }
        return c2;
        
    }
    
    
    public int rootOf(int p) {
        while ( p != parent[p]) {
            p = parent[parent[p]];
            // p = parent[p];
        }
        return p;
    }
}

// testcases
// [[1,2],[1,3],[2,3]]
// [[1,2], [2,3], [3,4], [4,1], [1,5]]
// [[2,1],[3,1],[4,2],[1,4]]
// [[1,2],[3,4],[3,5],[3,2],[3,1]]
// [[3,4],[4,1],[1,2],[2,3],[5,1]]
