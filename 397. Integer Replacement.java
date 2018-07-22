class Solution {
    public int integerReplacement(int n) {
        // check param
        if ( n <= 0 ) return 0;
        
        int count = 0;
        while ( n != 1 ) {
            count++;
            // when every time there comes two adjacent 1, we add 1 otherwise we minus 1, except for 3 which we will minus 1.
            if ( (n & 1) == 0 ) 
                n = n >>> 1;
            else if ( n == 3 || ((n >>> 1) & 1) == 0 ) 
                n--;
            else
                n++;
            
        }
        return count;
    }
}
