class Solution {
    public int divide(int dividend, int divisor) {
        int dividendabs = 0;
        int divisorabs = 0;
        int count = 0;
        int shift = 0;
        // in case of divisorabs overflow
        if( divisor == Integer.MIN_VALUE ) {
            if ( dividend == divisor ) return 1;
            else return 0;
        }
        // in case of dividend abs overflow
        if ( dividend == Integer.MIN_VALUE ) {
            if ( divisor == -1 ) return Integer.MAX_VALUE;
            dividendabs = Math.abs( Integer.MAX_VALUE);
            divisorabs = Math.abs(divisor);
            while(true){
                if( dividendabs < divisorabs) break;
                shift = 0;
                while( dividendabs - (divisorabs << shift) >= 0  ){//&& dividendabs - (divisorabs << shift) > divisorabs
                    shift++;
                }
                shift--;
                dividendabs -= ( divisorabs << shift );
                count += ( 1 << shift );
            }
            
            if( dividendabs == divisorabs - 1) return divisor > 0 ? 0-(count + 1) : (count + 1);
            else return divisor > 0 ? 0-count : count;
        }
        dividendabs = Math.abs( dividend );
        divisorabs = Math.abs(divisor);
        while(true){
            if( dividendabs < divisorabs) break;
            shift = 0;
            while( dividendabs - (divisorabs << shift) >= 0  ){//&& dividendabs - (divisorabs << shift) > divisorabs
                shift++;
            }
            shift--;
            dividendabs -= ( divisorabs << shift );
            count += ( 1 << shift );
            
        }
        if( (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0 ) ) return count;
        else return 0-count;
        
    }
}
//         old & bad solution
//         int dividendabs = 0;
//         int divisorabs = 0;
//         int count = 0;
//         // in case of divisorabs overflow
//         if( divisor == Integer.MIN_VALUE){
//             if( dividend == divisor) return 1;
//             else return 0;
//         }
//         // in case of dividendabs overflow
//         if( dividend == Integer.MIN_VALUE){
//             if( divisor == -1 ) return Integer.MAX_VALUE;
//             dividendabs = Math.abs( dividend + 1);
//             divisorabs = Math.abs(divisor);
//             while( dividendabs >= divisorabs){
//                 dividendabs -= divisorabs;
//                 count++;
//             }
//             if( (dividendabs+1) / divisorabs == 1) return count+1;
//             else return count;
//         }
        
//         dividendabs = Math.abs(dividend);
//         divisorabs = Math.abs(divisor);
//         while( dividendabs >= divisorabs ){
//             dividendabs -= divisorabs;
//             count++;
//         }
//         return ( (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) )? count : 0-count ;
