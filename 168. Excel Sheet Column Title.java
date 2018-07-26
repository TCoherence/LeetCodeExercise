class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while( n > 0 ) {
            int remainder = (n - 1) % 26;
            sb.append( (char)('A' + remainder) );
            if ( remainder == 25 ) 
                n -= 26;
            n /= 26;
        }
        
        return sb.reverse().toString();
    }
}
