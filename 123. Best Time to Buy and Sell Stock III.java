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
