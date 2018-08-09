class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // check param
        if ( nums == null || nums.length == 0 ) return new int[0];
        
        int[] res = new int[nums.length];
        Arrays.fill(res, -1); // excellent preprocessing.
        Stack<Integer> stack = new Stack<>(); // index stack
        for ( int i = 0; i < nums.length * 2; i++ ) {
            while ( !stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length] ) {
                res[stack.pop()] = nums[i % nums.length];
            }
            if ( i < nums.length )
                stack.push(i);
        }
        
        return res;
    }
}
