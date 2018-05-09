class Solution {
    public int maxProfit(int[] prices) {
        if( prices == null || prices.length == 0 || prices.length == 1) return 0;
        int len = prices.length;
        int maxProfit = 0;
        for ( int i = 0; i < len; i++){
            if ( i > 0 && prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}
