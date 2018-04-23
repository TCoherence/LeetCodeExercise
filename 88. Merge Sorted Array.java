class Solution {
    //虽然不可以从最小的开始排，但我们可以从最大的开始啊
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        m--;
        n--;
        
        while( m > -1 && n > -1){
            len--;
            if(nums1[m] >= nums2[n] ) {
                nums1[len] = nums1[m];
                m--;
            }
            else {
                nums1[len] = nums2[n];
                n--;
            }
        }
        if( n == -1 ){
            while (m>-1)
            {
                len--;
                nums1[len] = nums1[m];
                m--;
            }
        }
        else if ( m == -1 ){
            while(n>-1){
                len--;
                nums1[len] = nums2[n];
                n--;
            }
        }
    }
}
