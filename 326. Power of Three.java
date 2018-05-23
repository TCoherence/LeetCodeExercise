class Solution {
    public boolean isPowerOfThree(int n) {
        int maxPowerOfThree = (int)Math.pow(3, (int)( Math.log10(0x7fffffff) / Math.log10(3) ) );
        return (n > 0) && (maxPowerOfThree % n == 0);
    }
}
