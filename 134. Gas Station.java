class Solution {
    /* start must statisfy that sum(start, end) >= sum(0, start)
     * What we need to pay attention to is that sum(i, j) is used to 
     * calculate a new array --- array[i] = gas[i] - cost[i].
     * so if we go through the whole array and we store the first
     * index meets the requirements and it must the answer, or we have
     * to return -1
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int tank = 0;
        int sumBefore = 0;
        for ( int i = 0; i < gas.length; i++ ) {
            int dif = gas[i] - cost[i];
            // sum of start-to-i, <0, cannot be reached , keep going and update to sum of 0-to-i(sumBefore)
            if ( dif + tank < 0 ) {
                start = i + 1;
                sumBefore += (dif + tank);
                tank = 0;
            }
            // sum of start-to-i > 0
            else {
                tank += dif;
            }
        }
        return tank + sumBefore >= 0 ? start : -1;
    }
}
