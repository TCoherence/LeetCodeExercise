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
