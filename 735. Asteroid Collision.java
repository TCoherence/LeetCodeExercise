class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // check param
        if ( asteroids == null || asteroids.length == 0 ) return new int[]{};
        
        Stack<Integer> stack = new Stack<>();
        for ( int i = 0; i < asteroids.length; i++ ) {
            int size = asteroids[i];
            if ( size < 0 ) {
                while ( !stack.isEmpty() && stack.peek() > 0 && (stack.peek() + size < 0) ) {
                    stack.pop();
                }
                if ( stack.isEmpty() || stack.peek() < 0 ) 
                    stack.push(size);
                if ( stack.peek() + size == 0 ) 
                    stack.pop();
            }
            else 
                stack.push(size);
        }
        
        // update return array, res
        int[] res = new int[stack.size()];
        for ( int i = res.length - 1; i >= 0; i-- ) {
            res[i] = stack.pop();
        }
        return res;
    }
}
