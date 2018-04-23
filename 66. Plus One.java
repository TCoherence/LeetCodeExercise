class Solution {
    public int[] plusOne(int[] digits) {
        if ( digits == null ) return null;
        int len = digits.length;
        digits[len - 1]++;    
        for( int i = len - 2; i >= 0; i--){
            if( digits[i+1] == 10 ) digits[i]++;
        }
        if( digits[0] == 10) {
            int[] ret = new int[len+1];
            ret[0] = 1;
            for( int i = 1; i < len + 1; i++){
                ret[i] = digits[i-1] % 10;
            }
            return ret;
        }
        else{
            int[] ret = new int[len];
            for( int i = 0; i < len; i++){
                ret[i] = digits[i] % 10;
            }
            return ret;
        }


        
    }
}
