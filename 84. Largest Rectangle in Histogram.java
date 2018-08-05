class Solution {
    public int largestRectangleArea(int[] heights) {
        if ( heights == null || heights.length == 0 ) return 0;
        
        Stack<Integer> stack = new Stack<>(); // the key is we only store idx, not value
        
        int i = 0;
        int idx = 0;
        int len = 0;
        int localArea = 0;
        int globalArea = 0;
        while ( i < heights.length ) {
            if ( stack.isEmpty() || heights[stack.peek()] <= heights[i] ) {
                stack.push(i);
                i++;
            }
            else {
                idx = stack.pop();
                len = stack.isEmpty() ? i : i - stack.peek() - 1; 
                // in fact codeline above should be len = stack.isEmpty() ? i -(-1) - 1: i - stack.peek() - 1; 
                localArea = heights[idx] * len;
                globalArea = Math.max(localArea, globalArea);
            }
        }
        // if the last sequence is ascending.
        while ( !stack.isEmpty() ) {
            idx = stack.pop();
            len = stack.isEmpty() ? i : i - stack.peek() - 1;
            localArea = heights[idx] * len;
            globalArea = Math.max(localArea, globalArea);
        }
        return globalArea;
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
        System.out.printf("localArea = %d, globalArea = %d\n", localArea, globalArea);

        return globalArea;
    }
}

