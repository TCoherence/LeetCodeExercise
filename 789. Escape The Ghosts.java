class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        // because of note, no need to consider overflow
        int max = Math.abs(target[0]) + Math.abs(target[1]);
        for ( int[] ghost : ghosts ) {
            int dist = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            // if ghost can reach the target before me, i lose the game
            if ( dist <= max ) return false;
        }
        return true;
    }
}
