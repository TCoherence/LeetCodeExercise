class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // sort array with width then find LIS with height.
        // note that we cannot rotate a envelope
        if ( envelopes == null || envelopes.length == 0 ) 
            return 0;
            // throw java.lang.IllegalArgumentException();
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if ( a[0] == b[0] ) 
                    return b[1] - a[1];
                return a[0] - b[0];
            }
        });
        int[] tail = new int[envelopes.length];
        int len = 0;
        for ( int[] envelope : envelopes ) {
            int idx = Arrays.binarySearch(tail, 0, len, envelope[1]);
            if ( idx < 0 ) 
                idx = -(idx + 1);
            tail[idx] = envelope[1];
            if ( idx == len ) 
                len++;
        }
        return len;
    }
}
