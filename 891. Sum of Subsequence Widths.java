class Solution {
    public int sumSubseqWidths(int[] arr) {
        Arrays.sort(arr);
        long sum = 0l;
        int mod = 1000000007;
        long possibility = 1;
        for ( int i = 0; i < arr.length; i++, possibility = (possibility << 1) % mod ) {
            sum = (sum + arr[i] * possibility - arr[arr.length - 1 - i] * possibility) % mod;
        }
        return (int)((sum + mod)% 1000000007);
        
    }
    
}

