public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reverse = 0;
        int cnt = 0;
        while ( cnt < 32 ){
            reverse = reverse * 2 + (n & 1);
            n = n >>> 1;
            cnt++;
        }
        return reverse;
    }
}
