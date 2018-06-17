class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int len = A.length;
        int ret = -1;
        
        if (A[0] > A[1]) return 0;
        if (A[len - 1] > A[len - 2]) return len - 1;
        for ( int i = 1; i < len - 1; i++){
            if ( A[i] > A[i-1] && A[i] > A[i+1]) ret = i;
        }
        return ret;
    }
}
