class LRUCache {
    private int size;
    private int time;
    private HashMap<Integer, int[]> map;    // record, int[0] == time, int[1] == key, int[2] == value
    private PriorityQueue<int[]> pq;        // int[0] == time, int[1] == key, int[2] == value
    public LRUCache(int capacity) {
        pq = new PriorityQueue<>(capacity, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        map = new HashMap<>();
        time = 0;
        size = capacity;
    }
    
    public int get(int key) {
        if ( map.containsKey(key) ) {
            // update pq record
            int t = map.get(key)[0];
            int v = map.get(key)[2];
            if ( pq.remove(map.get(key)) ) {
                // System.out.printf("Remove success...\n");
            }
            int[] tmp = new int[]{time, key, v};
            pq.offer(tmp);
            map.replace(key, tmp);
            time++;
            // return value
            // System.out.printf("Time : %d, Size : %d, pq.size = %d \n", time, size, pq.size());
            return v;
        }
        // System.out.printf("Time : %d, Size : %d, pq.size = %d \n", time, size, pq.size());
        return -1;
    }
    
    public void put(int key, int value) {
        if ( map.containsKey(key) ) {
            int t = map.get(key)[0];
            int v = map.get(key)[2];
            pq.remove(map.get(key));
            int[] tmp = new int[]{time, key, value};
            pq.offer(tmp);
            map.replace(key, tmp);            
        }
        else {
            if ( pq.size() >= size ) {
                int[] triple = pq.poll();
                // System.out.printf("Removing key:%d from map...\n", triple[1]);
                map.remove(triple[1]);
            }
            int[] tmp = new int[]{time, key, value};
            pq.offer(tmp);
            map.put(key, tmp);
        }
        time++;
        // System.out.printf("Time : %d, Size : %d, pq.size = %d \n", time, size, pq.size());
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
