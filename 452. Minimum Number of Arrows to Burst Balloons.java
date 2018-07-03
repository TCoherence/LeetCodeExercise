class Solution {
    public int findMinArrowShots(int[][] points) {
        // check para
        if ( points == null || points.length == 0 || points[0].length == 0 ) return 0;
        
        // sort array by end
        Arrays.sort(points, new Comparator<int[]> () {
           public int compare(int[] a, int[] b){
               return a[1] - b[1];
           } 
        });
        
        // loop the whole array and check if start is larger than end, larger then update end or keep moving
        int end = points[0][1];
        int cnt = 1;
        for ( int i = 1; i < points.length; i++ ) {
            if ( points[i][0] > end ){
                cnt++;
                end = points[i][1];
            }    
        }
        
        // 
        return cnt;
    }
}
