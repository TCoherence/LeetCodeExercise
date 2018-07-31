class Solution {
    public int hIndex(int[] citations) {
        if ( citations == null || citations.length == 0 ) return 0;
        
        Arrays.sort(citations);
        int hidx = 0;
        for ( int i = citations.length - 1; i >= 0; i-- ) {
            while ( i > 0 && citations[i - 1] == citations[i] ) i--;
            if ( citations[i] <= citations.length - i ) {
                hidx = Math.max(hidx, citations[i]);
                break;
            }
            hidx = citations.length - i;
        }
        return hidx;
    }
}
