class Solution {
    public int[] countBits(int num) {
        if ( num == 0 ) return new int[]{0};
        if ( num == 1 ) return new int[]{0,1};
        int[] res = new int[num + 1];
        for ( int i = 1; i < num + 1; i *= 2){
            if ( i * 2 > num ) {
                for ( int j = 0; j < num - i + 1; j++ ){
                    res[i+j] = 1 + res[j];
                }
            }
            else{
                for ( int j = 0; j < i; j++ ){
                    res[i+j] = 1 + res[j];
                }
            }
        }
        return res;
    }
}
