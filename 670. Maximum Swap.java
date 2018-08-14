class Solution {
    public int maximumSwap(int num) {
        char[] str = Integer.toString(num).toCharArray();
        int[] bucket = new int[10];
        for ( int i = 0; i < str.length; i++ ) {
            bucket[str[i] - '0'] = i;
        }
        for ( int i = 0; i < str.length; i++ ) {
            for ( int k = 9; k > str[i] - '0'; k-- ) {
                if ( bucket[k] > i ) {
                    swap(str, bucket[k], i);
                    return Integer.valueOf(new String(str)).intValue();
                }
            }
        }
        return num;
    }
    
    public void swap(char[] str, int i, int j) {
        str[i] ^= str[j];
        str[j] ^= str[i];
        str[i] ^= str[j];
    }
}
