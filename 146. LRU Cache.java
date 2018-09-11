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

// redo
class LRUCache {
    private Map<Integer, DLNode>    map;
    // private Map<Integer, Integer>   nodePair;
    private DLNode                  head, tail;
    private int                     capacity;
    private int                     size;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new DLNode(-1, -1, null, null);
        tail = new DLNode(-1, -1, null, null);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        this.size = 0;
    }
    
    public int get(int key) {
        if ( !map.containsKey(key) ) return -1;
        int ret = map.get(key).val;
        moveToHead(map.get(key));
        return ret;
    }
    
    public void put(int key, int value) {
        if ( map.containsKey(key) ) {
            // update double-linked list and nodepairs
            map.get(key).val = value;
            moveToHead(map.get(key));
        }
        else {
            if ( size < capacity ) {
                size++;
                DLNode toAdd = new DLNode(key, value, null, null);
                add(toAdd);
                map.put(key, toAdd);
            }
            else {
                DLNode toDel = tail.prev;
                DLNode toAdd = new DLNode(key, value, null, null);
                delete(tail.prev);
                map.remove(toDel.key);
                add(toAdd);
                map.put(key, toAdd);
                
            }
        }
    }
    private void add(DLNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    private void delete(DLNode node) {
        DLNode prev = node.prev;
        DLNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    private void moveToHead(DLNode node) {
        delete(node);
        add(node);
    }
        
        
        
        
    private class DLNode {
        private int     key;
        private int     val;
        private DLNode  prev;
        private DLNode  next;
        DLNode(int key, int val, DLNode prev, DLNode next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
