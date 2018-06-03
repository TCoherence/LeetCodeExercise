class Solution {
    public int longestMountain(int[] arr) {
        int len = arr.length;
        int max = 0;
        int cnt = 0;
        
        for ( int i = 1; i < len - 1; i++){
            int frn = 0;
            int bck = 0;
            for ( int front = i; front + 1 < len; front++ ){
                if ( arr[front] > arr[front + 1] ) frn++;
                else {
                    break;
                }
            }
            for ( int back = i; back - 1 >= 0; back-- ){
                if ( arr[back] > arr[back - 1] ) bck++;
                else {
                    break;
                }
            }
            if (frn == 0 || bck == 0 ) {
                continue;
            }
            
            cnt = frn + bck;
            max = Math.max(max, cnt + 1);
            cnt = 0;
        }
        return max;
    }
}
