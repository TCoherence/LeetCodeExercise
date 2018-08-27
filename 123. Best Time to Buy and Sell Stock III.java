class Solution {
    public int maxProfit(int[] prices) {
        return helper(2, prices);
    }
    public int helper(int k, int[] prices) {
        if ( prices == null ) return 0;
        if ( prices.length == 0 || prices.length == 1 ) return 0;
        
        if (k >= prices.length >>> 1) {
            int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
    
        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price);
        }
        
        return T_ik0;
    }
        
        int[] s0 = new int[k + 1];
        int[] s1 = new int[k + 1];
        Arrays.fill(s1, Integer.MIN_VALUE);
        for ( int j = 0; j < prices.length; j++ ){
            for ( int i = 1; i <= k; i++){
                s0[i] = Math.max(s0[i], s1[i] + prices[j]);
                s1[i] = Math.max(s1[i], s0[i-1] - prices[j]);
            } 
        }
        return s0[k];
    }
}

// redo
class Solution {
    public int maxProfit(int[] prices) {
        return maxProfithelper(2, prices);
    }
    private int maxProfithelper(int k, int[] prices) {
        if ( prices == null ) return 0;
        if ( prices.length == 0 ) return 0;
        // case optimization
        if ( k >= (prices.length >>> 1) ) {
            // prices.length / 2 <= k, become problem that we can buy and sold in scale of groups.
            int sum = 0, min = prices[0], max = prices[0];
            for ( int i = 0; i < prices.length; i++ ) {
                if ( prices[i] > max )  {
                    max = prices[i];
                    if ( i == prices.length - 1 ) {
                        sum += max - min;
                        min = prices[i];
                    }
                }
                else {
                    sum += max - min;
                    min = prices[i];
                    max = prices[i];
                }
            }
            return sum;
            
        }
        int[] soldAt = new int[k + 1];
        int[] buyAt = new int[k + 1];
        Arrays.fill(buyAt, Integer.MIN_VALUE);
        for ( int price : prices ) {
            for ( int i = 1; i <= k; i++ ) {
                soldAt[i] = Math.max(soldAt[i], buyAt[i] + price);
                buyAt[i] = Math.max(buyAt[i], soldAt[i - 1] - price);
            }
        }
        return soldAt[k];
    }
}
