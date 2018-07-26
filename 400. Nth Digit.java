class Solution {
    public int findNthDigit(int n) {
        int len = 1;
        int start = 1;
        long base = 9;
        while ( n > len * base ) {
            n -= len * (int)base;
            len++;
            base *= 10;
            start *= 10;
        }
        int targetNum = start + (n - 1)/len;
        int targetBit = (n - 1) % len;
        len--;
        while ( len - targetBit > 0 ) {
            targetNum /= 10;
            len--;
        } 
        return targetNum % 10;
        // return Integer.valueOf(Integer.toString(targetNum).charAt(targetBit)) - 48;
        
        
    }
}
