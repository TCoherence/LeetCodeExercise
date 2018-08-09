class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        for ( boolean isVisited : visited ) {
            if ( !isVisited ) return false;
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms, int idx, boolean[] visited) {
        if ( visited[idx] ) return;
        visited[idx] = true;
        for ( int nextRoom : rooms.get(idx) ) {
            dfs(rooms, nextRoom, visited);
        }
    }
}
