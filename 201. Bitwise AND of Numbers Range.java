class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        // if ( m == 0 ) return 0;
        int cnt1 = (int)(Math.log(m) / Math.log(2));
        int cnt2 = (int)(Math.log(n) / Math.log(2)); 
        
        if ( cnt1 != cnt2 ) return 0;
        int res = 0;
        int cnt = 1 << cnt1;
        // we can use Integer.MAX_VALUE to locate same prefix
        while ( cnt > 0 && (cnt & m ) == (cnt & n) ) {
            res += (cnt & m);
            cnt = cnt >> 1;
        }
        
        return res;
    }
}
