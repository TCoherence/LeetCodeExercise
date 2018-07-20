class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // check param
        if ( numCourses <= 0 || prerequisites == null ) return new int[]{};
        
        List<Integer> res = new ArrayList<>();
        int[] isVisit = new int[numCourses];
        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer>[] graph = new List[numCourses];
        for ( int i = 0; i < numCourses; i++ ) {
            graph[i] = new ArrayList<Integer>();
        }
        for ( int[] pre : prerequisites ) {
            graph[pre[1]].add(pre[0]);
            isVisit[pre[0]]++;
        }
        for ( int i = 0; i < numCourses; i++ ) {
            if ( isVisit[i] == 0 ) {
                q.offer(i);
            }
        }
        if( q.isEmpty() ) return new int[]{};
        int[] ret = new int[numCourses];
        int index = 0;
        while ( !q.isEmpty() ) {
            int size = q.size();
            for ( int j = 0; j < size; j++ ) {
                int level = q.poll();
                ret[index++] = level;
                for ( int i : graph[level] ) {
                    isVisit[i]--;
                    if ( isVisit[i] == 0 ) {
                        q.offer(i);
                        // graph[level].remove(i);
                        
                    }
                }
                
            }
        }
        // int[] ret = (int[])res.toArray();
        return index == numCourses ? ret : new int[]{};
    }
}
