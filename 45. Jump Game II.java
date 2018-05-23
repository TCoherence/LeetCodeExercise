class Solution {
    public int jump(int[] nums) {
        if ( nums == null || nums.length == 0 ) return 0;
        int farestOld = 0;
        int farestNew = 0;
        int[] step = new int[nums.length];
        int len = nums.length;
        for ( int i = 0; i < len - 1; i++ ){
            if ( i + nums[i] > farestNew ) {
                farestNew = i + nums[i];
                for ( int j = farestNew; j > farestOld; j--){
                    if ( j >= len ) continue;
                    step[j] = step[i] + 1;
                }
                farestOld = farestNew;
            }
            
        }
        return step[len - 1];
        
    }
}
