class Solution {
    public int singleNumber(int[] nums) {
        int nb = 0, na = 0;
        int b = 0, a = 0;
        for ( int i = 0; i < nums.length; i++){
            nb = ~a & ( b ^ nums[i] );
            na = a&~b&~nums[i] | ~a&b&nums[i];
            a = na;
            b = nb;
        }
        return nb;
    }
}
