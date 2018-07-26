class Solution {
    private int[] parent;
    private int[] size;
    
    public int[] findRedundantConnection(int[][] edges) {
        // check param
        if ( edges == null || edges.length == 0 || edges[0].length == 0 ) return null;
        
        parent = new int[edges.length + 1];
        size = new int[edges.length + 1];
        
        // initial
        for ( int i = 0; i < edges.length + 1; i++ ) {
            parent[i] = i;
            size[i] = 1;
        }
        
        
        for (int[] edge : edges ) {
            int i = rootOf(edge[0]);
            int j = rootOf(edge[1]);
            if ( i == j ) 
                return edge;
            else {
                if ( size[i] > size[j] ) {
                    parent[j] = i;
                    size[i] += size[j];
                }
                else {
                    parent[i] = j;
                    size[j] += size[i];
                }
            }
        }
        return null;
    }
    
    public int rootOf(int p) {
        while ( p != parent[p] ) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
