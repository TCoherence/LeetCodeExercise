class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        // 
        if ( houses == null || heaters == null || houses.length == 0 || heaters.length == 0 ) return -1;

        int min = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for ( int i = 0; i < houses.length; i++ ) {
            min = Math.max(min, bs(houses[i], heaters));
        }
        return min;
    }
    
    public int bs(int pos, int[] heaters) {
        
        int lo = 0; 
        int hi = heaters.length - 1;
        if ( pos <= heaters[lo] ) return heaters[lo] - pos;
        if ( pos >= heaters[hi] ) return pos - heaters[hi];
        int min = Integer.MAX_VALUE;
        while ( lo <= hi ) {
            int mid = lo + (hi - lo) / 2;
            min = Math.min(min, Math.abs(heaters[mid] - pos));
            if ( pos > heaters[mid] ) 
                lo = mid + 1;
            else if ( pos < heaters[mid] )
                hi = mid - 1;
            else {
                mid = 0;
                break;
            }
        }
        return min;
    }
}
