class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int two = 0;
        int one = 0;
        int min = 0;
        for ( int i = 2; i <= cost.length; i++ ){
            min = Math.min( cost[i-1] + one, cost[i-2] + two);
            two = one;
            one = min; 
        }
        return min;
        
    }
}
