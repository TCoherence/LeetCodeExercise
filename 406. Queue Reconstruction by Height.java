class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // check para
        if ( people == null || people.length == 0 || people[0].length == 0 ) {//throw new java.lang.IllegalArgumentException("Array invalid."); 
            return people;
        }
        if ( people.length == 1 ) return people;
        
        int row = people.length;
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if ( a[0] == b[0]) 
                    return a[1] - b[1];
                else 
                    return b[0] - a[0];
            }
        });
        
        int[] tmp = new int[]{1,2};
        Node head = new Node(tmp, 2);
        for ( int[] person : people ) {
            int idx = person[1];
            Node node = head;
            while ( idx-- > 0 ) 
                node = node.next;
            node.insert(new Node(person, person.length));
        }
        
        head = head.next;
        for ( int[] person : people ) {
            person[0] = head.val[0];
            person[1] = head.val[1];
            head = head.next;
        }
        return people;
    }
    
    private class Node {
        private int[] val;
        private Node next;
        
        public Node(int[] value, int len){
            val = new int[len];
            for ( int i = 0; i < len; i++ ) 
                val[i] = value[i];
        }
        
        public void insert(Node node) {
            Node tmp = this.next;
            this.next = node;
            node.next = tmp;
        }
    }
}
