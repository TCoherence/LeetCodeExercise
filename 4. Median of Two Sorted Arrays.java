class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if ( n < m ) return findMedianSortedArrays(nums2,nums1);
        int imin = 0;
        int imax = m;
        int i = (imin+imax) / 2;
        int j = (m+n+1) / 2 - i;
        
        while( imin <= imax ) {
            i = (imin+imax) / 2;
            j = (m+n+1) / 2 - i;
            if ( i < m && nums1[i] < nums2[j-1] ){
                // i too small
                imin = i + 1;
            }
            else if( i > 0 && nums1[i-1] > nums2[j] ){
                // i too large
                imax = i - 1;
            }
            else break;
        }
        int maxleft = 0;
        int minright = 0;
        if ( i == 0 ) maxleft = nums2[j-1];
        else if( j == 0) maxleft = nums1[i-1];
        else maxleft = Math.max(nums1[i-1], nums2[j-1]);
        if( ((m+n) & 0x1) == 1) return maxleft;
        
        if( i == m) minright = nums2[j];
        else if ( j == n ) minright = nums1[i];
        else minright = Math.min(nums1[i], nums2[j]);
        return (maxleft+minright) / 2.0;
    }
}

// Redo 
class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        if ( A == null || B == null ) return 0.0; // be careful about empty array.
        
        if ( A.length > B.length ) {
            int[] tmp = A;
            A = B;
            B = tmp;
        }
        int m = A.length, n = B.length;
        int iMin = 0, iMax = m, i = -1, j = -1;
        int half = (m + n + 1) / 2; // this indicates that when m plus n is odd the left part will 
                                    // have one more number than the right part;
        int maxLeft = 0, minRight = 0;
        while ( iMin <= iMax ) {
            i = iMin + (iMax - iMin) / 2;
            j = half - i;
            if ( i > 0 && A[i - 1] > B[j] ) {
                iMax = i - 1;
            }
            else if ( i < m && B[j - 1] > A[i] ) {
                iMin = i + 1;
            }
            else {
                if ( i == 0 ) maxLeft = B[j - 1];
                else if ( j == 0 ) maxLeft = A[i - 1];
                else maxLeft = Math.max(A[i - 1], B[j - 1]);
                
                if ( ((m + n) & 1) == 1 ) return maxLeft;
                
                if ( i == m ) minRight = B[j];
                else if ( j == n ) minRight = A[i];
                else minRight = Math.min(A[i], B[j]);
                
                return (maxLeft + minRight) / 2.0;
                
            }
        }
        return -1;
    }
}
