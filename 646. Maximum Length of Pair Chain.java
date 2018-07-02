class Solution {
    public int findLongestChain(int[][] pairs) {
        // check para
        if ( pairs == null || pairs.length == 0 || pairs[0].length == 0 ) return 0;
        
        // sort array according to a[0](b[0])
        // the following code when I use lambda expression will be much slower than use comparator.
        Arrays.sort(pairs, new Comparator<int[]> () {
            public int compare(int[] array1, int[] array2){
                return array1[1] - array2[1];
            }
        });
        
        // maintain two var, localMax and globalMax;
        int localMax = 1;
        // int globalMax = 1;
        int end = pairs[0][1];
        for (int i = 1; i < pairs.length; i++){
            // latter's first > former's last
            if (pairs[i][0] > end) {
                localMax++;
                end = pairs[i][1];
            }
        }
        return localMax;
    }
}
