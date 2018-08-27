class Solution {
    public int trap(int[] height) {
        // check para
        if ( height == null || height.length == 0 ) return 0;
        
        int left = 0;
        int right = height.length - 1;
        int count = 0;
        
        for ( int i = 1; i < height.length; i++ ) {
            if ( height[left] <= height[i] ) left++;
            break;
        }
        for ( int i = height.length - 2; i >= 0; i-- ) {
            if ( height[right] <= height[i] ) right--;
            break;
        }
        
        while ( left < right ) {
            if ( height[left] <= height[right] ) {
                int localLeft = left;
                while ( localLeft < right && height[left] >= height[++localLeft] ) {
                    count += height[left] - height[localLeft];
                }
                left = localLeft;
            }
            else {
                int localRight = right;
                while ( localRight > left && height[right] >= height[--localRight] ) {
                    count += height[right] - height[localRight];
                }
                right = localRight;
            }
        }
        return count;
        
    }
}

// Two pointers, we can go through from two sides or from the same side!!! It is very important to keep this in mind.


// redo , more concise
class Solution {
    public int trap(int[] height) {
        if ( height == null || height.length == 0 || height.length == 1 ) return 0;
        int left = 0, right = height.length - 1;
        while ( height[left]  == 0 ) left++;
        while ( height[right] == 0 ) right--;
        int sum = 0;
        while( left < right ) {
            if ( height[left] < height[right] ) {
                int l = left + 1;
                while ( l < right && height[l] < height[left] ) {
                    sum += height[left] - height[l];
                    l++;
                }
                left = l;
            }
            else {
                int r = right - 1;
                while ( r > left && height[r] < height[right] ) {
                    sum += height[right] - height[r];
                    r--;
                }
                right = r;
            }
        }
        return sum;
    }
}
