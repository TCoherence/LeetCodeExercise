class Solution {
    public boolean isBipartite(int[][] graph) {
        // No triangle pattern.
        boolean[] marked = new boolean[graph.length];
        Set<Integer> sameLevel = null;
        Set<Integer> old = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for ( int k = 0; k < graph.length; k++ ) {
            if ( graph[k].length != 0 && !marked[k] ) {
                queue.offer(k);
                marked[k] = true;
                while ( !queue.isEmpty() ) {
                    int size = queue.size();
                    sameLevel = old;
                    old = new HashSet<>();
                    for ( int i = 0; i < size; i++ ) {
                        int node = queue.poll();
                        for ( int j = 0; j < graph[node].length; j++ ) {
                            if ( sameLevel.contains(graph[node][j]) ) return false;
                            if ( marked[graph[node][j]] ) continue;
                            old.add(graph[node][j]);
                            queue.offer(graph[node][j]);
                            marked[graph[node][j]] = true;
                        }
                    }
                }
            }   
        }
        return true;
    }
}

// Redo
class Solution {
    public boolean isBipartite(int[][] graph) {
        // check param
        if ( graph == null || graph.length == 0 ) return false;
        
        // no triangle exist
        Queue<Integer> queue = new LinkedList<>();   // queue to loop
        Set<Integer> seen = new HashSet<>();        // has been seen & operated
        Set<Integer> q = new HashSet<>();                  // still in the queue
        for ( int i = 0; i < graph.length; i++ ) {
            if ( graph[i].length != 0 && !seen.contains(i) ) {
                queue.add(i);
                while ( !queue.isEmpty() ) {
                    int size = queue.size();
                    Set<Integer> tmp = new HashSet<>();
                    for ( int j = 0; j < size; j++ ) {
                        int id = queue.poll();
                        seen.add(id);
                        for ( int point : graph[id] ) {
                            if ( q.contains(point) ) return false;
                            if ( seen.contains(point) ) continue;
                            if ( !tmp.contains(point) ) {
                                queue.offer(point);
                                tmp.add(point);
                            }
                        }
                    }
                    q = tmp;
                }
            }
        }
        
        return true;
    }
}        
        
//         while ( !queue.isEmpty() ) {
//             int size = queue.size();
//             Set<Integer> tmp = new HashSet<>();
//             for ( int i = 0; i < size; i++ ) {
//                 int id = queue.poll();
//                 seen.add(id);
                
//                 // System.out.printf("We are processing %d\n", id);
//                 // for its neighbors, we need to check two conditions: in the same queue or is his father
//                 for ( int point : graph[id] ) {
//                     // System.out.printf("--its neighbor is %d,\t", point);
//                     if ( q.contains(point) ) return false;
//                     if ( seen.contains(point) ) continue;
//                     if ( !tmp.contains(point) ) {
//                         queue.offer(point);
//                         tmp.add(point);
//                     }
                        
//                 }
//                 // System.out.println("");
//             }
//             q = tmp;
//         }
            
