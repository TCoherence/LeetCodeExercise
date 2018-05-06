class Solution {
    public int maxArea(int[] height) {
        if ( height == null || height.length == 0 || height.length == 1 ) return 0;
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while ( left < right ){
            int len = right - left;
            int tmp = height[left] < height[right] ? height[left] * len : height[right] * len;
            max = Math.max( tmp, max );
            if ( height[left] < height[right] ) left++;
            else right--;
        }
        return max;
    }
}
