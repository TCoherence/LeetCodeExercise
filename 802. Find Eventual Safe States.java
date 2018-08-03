class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // check param
        if ( graph == null || graph.length == 0 ) return new ArrayList<Integer>();
        
        List<Integer> res = new ArrayList<>();
        // tag array 
        // 0 -- not visit yet
        // 1 -- safe
        // 2 -- unsafe
        int[] tag = new int[graph.length];
        for ( int i = 0; i < graph.length; i++ ) {
            if ( isSafe(graph, i, tag) ) res.add(i);
        }
        return res;
    }
    
    public boolean isSafe(int[][] graph, int cur, int[] tag) {
        if ( graph[cur].length == 0 ) return true;
        if ( tag[cur] != 0 ) return tag[cur] == 1;

        tag[cur] = 2;
        for ( int edgeTo : graph[cur] ) {
            if ( !isSafe(graph, edgeTo, tag) ) return false;
        }
        tag[cur] = 1;
        return true;
    }
}
