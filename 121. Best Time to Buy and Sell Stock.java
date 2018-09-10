class Solution {
    public int maxProfit(int[] prices) {
        if ( prices == null || prices.length == 0 ) return 0;
        
        int min = prices[0];
        int ret = 0;
        for ( int i = 1; i < prices.length; i++ ) {
            if ( prices[i] < min ) 
                min = prices[i];
            else {
                ret = Math.max(ret, prices[i] - min);
            }
        }
        return ret;
    }
}
