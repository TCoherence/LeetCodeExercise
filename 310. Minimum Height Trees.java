class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // check para
        if ( n <= 0 || edges == null ) return new ArrayList<Integer>();
        
        if ( n == 1 ) return Collections.singletonList(0); // mistake one
        
        List<HashSet<Integer>> graph = new ArrayList<HashSet<Integer>>();
        for ( int i = 0; i < n; i++ ) {
            graph.add(new HashSet<Integer>());
        }
        // re-build graph
        for ( int[] edge : edges ) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves = new ArrayList<Integer>();
        for ( int i = 0; i < n; i++ ) {
            if ( graph.get(i).size() == 1 ) 
                leaves.add(i);
        }
        
        while ( n > 2 ) {
            n -= leaves.size(); // mistake two
            List<Integer> newLeaves = new ArrayList<Integer>();
            for ( int i : leaves ) {
                int j = graph.get(i).iterator().next();
                graph.get(j).remove(i);
                if ( graph.get(j).size() == 1 ) 
                    newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        
        return leaves;
        
    }
}
