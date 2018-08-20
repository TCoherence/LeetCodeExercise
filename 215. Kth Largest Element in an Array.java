class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for ( int num : nums ) {
            pq.offer(num);
        }
        while ( k > 1 ) {
            k--;
            pq.poll();
        }
        return pq.poll();
    }
}
