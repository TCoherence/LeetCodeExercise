class Solution {
    public int maximalRectangle(char[][] matrix) {
        // check param
        if ( matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        // forloop update heights in row level
        int max = 0;
        int[] heights = new int[matrix[0].length]; // we can do this because matrix's property
        for ( int i = 0; i < matrix.length; i++ ) {
            for ( int j = 0; j < matrix[0].length; j++ ) {
                if ( matrix[i][j] == '1' ) {
                    heights[j]++;
                }
                else{
                    heights[j] = 0; // cut the non-consecutive '1's
                }
            }
            // System.out.printf("heights = %s\n", Arrays.toString(heights));
            max = Math.max(max, largestRectInHist(heights));
        }
        return max;
    }
    public int largestRectInHist(int[] heights) {
        if ( heights == null || heights.length == 0 ) return 0;
        
        int[] firstLessLeft = new int[heights.length];
        int[] firstLessRight = new int[heights.length];
        firstLessLeft[0] = -1;
        firstLessRight[heights.length - 1] = heights.length;
        // update two arrays above
        for ( int i = 0; i < heights.length; i++ ) {
            int j = i - 1;
            while ( j >= 0 && heights[j] >= heights[i] ) {
                j = firstLessLeft[j];
            }
            firstLessLeft[i] = j;
        }
        for ( int i = heights.length - 1; i >= 0; i-- ) {
            int j = i + 1;
            while ( j < heights.length && heights[j] >= heights[i] ) {
                j = firstLessRight[j];
            }
            firstLessRight[i] = j;
        }
        int localArea = 0;
        int globalArea = 0;
        for ( int i = 0; i < heights.length; i++ ) {
            localArea = heights[i] * (firstLessRight[i] - firstLessLeft[i] - 1);
            globalArea = Math.max(globalArea, localArea);
        }
        // System.out.printf("localArea = %d, globalArea = %d\n", localArea, globalArea);

        return globalArea;
    }
}
