class Solution {
    public int candy(int[] ratings) {
        // check param
        if ( ratings == null || ratings.length == 0 ) return -1;
        
        int cur = 1;
        int sum = 1;
        int len = 1;
        boolean rep = false;
        for ( int i = 1; i < ratings.length; i++ ) {
            // 
            if ( ratings[i] > ratings[i - 1] ) {
                if ( len == 1 ) {
                    cur++;
                    sum += cur;
                    len = 1;
                }
                else {
                    sum = sum - (cur - 1) * (len - 1);
                    cur = 2;
                    sum += cur;
                    len = 1;
                }
            }
            else if ( ratings[i] < ratings[i - 1] ) {
                if ( cur == 1 ) {
                    len++;
                    sum += len;

                }
                else {
                    cur--;
                    sum += cur;
                    len++;
                }
            }
            else { // ratings[i] == ratings[i - 1]
                // cur = 1;
                // len = 1;
                // sum += cur;
                if ( len == 1 ) {
                    cur = 1;
                    sum += cur;
                    len = 1;
                }
                else {
                    sum = sum - (cur - 1) * (len - 1);
                    cur = 1;
                    sum += cur;
                    len = 1;
                }
            }
        }
        if ( len != 1 ) 
            sum -= (cur - 1) * (len - 1);
        return sum;
    }
}
