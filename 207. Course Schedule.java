class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // check param
        if ( numCourses <= 0 || prerequisites == null ) return false;
        
        //List<Integer> res = new ArrayList<>();
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
        int count = 0;
        while ( !q.isEmpty() ) {
            int size = q.size();
            for ( int i = 0; i < size; i++ ) {
                int level = q.poll();
                count++;
                for ( int j : graph[level] ) {
                    isVisit[j]--;
                    if ( isVisit[j] == 0 ) q.offer(j);
                }
            }
        }
        return count == numCourses;
        
    }
}
