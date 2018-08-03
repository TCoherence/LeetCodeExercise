class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null) throw new java.lang.IllegalArgumentException();
        int firstzero = 0;
        boolean isfirstzero = true;
        for(int firstnonzero = 0; firstnonzero < nums.length; firstnonzero++ ){
            if(nums[firstnonzero] == 0){
                if(isfirstzero) {
                    isfirstzero = false;
                    firstzero = firstnonzero;
                }
                else continue;
            }
            else{
                int tmp = nums[firstzero];
                nums[firstzero] = nums[firstnonzero];
                nums[firstnonzero] = tmp;
                firstzero++;
            }
            
        }
    }
}
