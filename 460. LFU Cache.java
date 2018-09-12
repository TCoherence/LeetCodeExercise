class LFUCache {
    private HashMap<Integer, DLNode>    cache;
    private HashMap<Integer, nodeList>  freq;
    private int                         capacity;
    private int                         count;
    private int                         min;
    // private DLNode                      head, tail;
    public LFUCache(int capacity) {
        cache = new HashMap<>();
        freq = new HashMap<>();
        // freq.put(0, tail);
        this.capacity = capacity;
        count = 0;
        min = 1;
        
        
    }
    
    public int get(int key) {
        DLNode node = cache.get(key);
        if ( node == null ) return -1;
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if ( capacity == 0 ) return ;
        DLNode node = cache.get(key);
        if ( node == null ) {
            // remove first
            if ( count == capacity ) {
                DLNode tmp = freq.get(min).popTail();
                cache.remove(tmp.key);
                count--;
            }
            count++;
            node = new DLNode();
            node.key = key;
            node.value = value;
            node.freq = 1;
            min = 1;
            nodeList list = freq.getOrDefault(1, new nodeList());
            list.add(node);
            freq.put(1, list);
            cache.put(key, node);
        }
        else {
            node.value = value;
            update(node);
        }
    }
    public void update(DLNode node) {
        nodeList oldFreqList = freq.get(node.freq);
        node.freq = node.freq + 1;
        oldFreqList.remove(node);
        if ( node.freq - 1 == min && oldFreqList.size == 0 ) min++;
        if ( !freq.containsKey(node.freq) ) {
            freq.put(node.freq, new nodeList());
        }
        freq.get(node.freq).add(node);
    }
    
    
    private class DLNode {
        int     key;
        int     freq;
        int     value;
        DLNode  pre;
        DLNode  post;
    }
    private class nodeList {
        DLNode  head, tail;
        int     size;
        nodeList() {
            head = new DLNode();
            tail = new DLNode();
            head.pre = null;
            head.post = tail;
            tail.pre = head;
            tail.post = null;
            size = 0;
        }
        private void add(DLNode node) {
            DLNode post = head.post;
            head.post = node;
            node.pre = head;
            node.post = post;
            post.pre = node;
            size++;
        }
        private void remove(DLNode node) {
            DLNode pre = node.pre;
            DLNode post = node.post;
            pre.post = post;
            post.pre = pre;
            size--;
        }
        private DLNode popTail() {
            if ( size == 0 ) return null;
            DLNode tmp = tail.pre;
            remove(tmp);
            return tmp;
        }
    }
    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// REDO
class LFUCache {
    private Map<Integer, DLNode[]>      freq2list; // find list's head and tail according to the freq
    private Map<Integer, DLNode>        pair2node; // find pair's relative DLNode according to the key
    private Map<Integer, Integer>       pair2freq; // find pair's freq according to its key
    // private Set<Integer, Set<Integer>>  freq2keySet; // freq map to its keySet ( to check if key is in this frequency)
    private int                         size, capacity, minFreq;
    public LFUCache(int capacity) {
        pair2node = new HashMap<>();
        freq2list = new HashMap<>();
        pair2freq = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        DLNode node = pair2node.get(key);
        if ( node == null ) return -1;
        int freq = pair2freq.get(key);
        delete(node, freq);
        add(node, freq + 1);
        pair2freq.put(node.key, freq + 1);
        return node.val;
    }
    
    public void put(int key, int value) {
        if ( capacity == 0 ) return;
        DLNode node = pair2node.get(key);
        if ( node == null ) {
            if ( size == capacity ) {
                size--;
                DLNode toDel = freq2list.get(minFreq)[1].prev;
                delete(toDel, minFreq);
                pair2node.remove(toDel.key);
            }
            size++;
            DLNode toAdd = new DLNode(key, value);
            pair2node.put(key, toAdd);
            add(toAdd, 1);
            pair2freq.put(toAdd.key, 1);
        }
        else { // node != null
            // update node's information
            node.val = value;
            int freq = pair2freq.get(key);
            delete(node, freq);
            add(node, freq + 1);
            pair2freq.put(node.key, freq + 1);
        }
    }
    private void add(DLNode node, int freq) {
        // check param
        if ( node == null ) return;
        // if freq is existed
        if ( !freq2list.containsKey(freq) ) {
            DLNode head = new DLNode(-1, -1);
            DLNode tail = new DLNode(-1, -1);
            head.next = tail;
            tail.prev = head;
            freq2list.put(freq, new DLNode[]{head, tail});
            
        }
        // add to this freq
        DLNode head = freq2list.get(freq)[0];
        DLNode tail = freq2list.get(freq)[1];
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        // if it is the first time to add, update minFreq
        if ( freq == 1 ) minFreq = 1;
    }
    
    private void delete(DLNode node, int freq) {
        if ( node == null ) return;
        DLNode head = freq2list.get(freq)[0];
        DLNode tail = freq2list.get(freq)[1];
        DLNode prev = node.prev;
        DLNode next = node.next;
        prev.next = next;
        next.prev = prev;
        if ( freq == minFreq && next == tail && prev == head ) minFreq++;
    }
    private class DLNode {
        private DLNode prev;
        private DLNode next;
        private int key, val;
        DLNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
