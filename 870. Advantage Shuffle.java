class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        // check param, already satisfy, no need to check
        Arrays.sort(A);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
        for ( int i = 0; i < B.length; i++ ) {
            pq.offer(new int[]{B[i], i});
        }
        int[] res = new int[A.length];
        int lo = 0, hi = A.length - 1;
        while ( !pq.isEmpty() ) {
            int[] b = pq.poll();
            if ( b[0] < A[hi] ) 
                res[b[1]] = A[hi--];
            else {
                res[b[1]] = A[lo++];
            }
        }
        return res;
    }
}
