class ExamRoom {
    int                 num;      // Number of seat
    TreeSet<Integer>    seat;     // Index of seats
    TreeSet<Point>      seg;      // Segment presentation of seats
    public ExamRoom(int N) {
        if ( N <= 0 ) return;
        num = N;
        seat = new TreeSet<>();
        seat.add(-1);
        seat.add(num);
        seg = new TreeSet<>(
            (Point seg1, Point seg2) -> {
                int d1 = getDistance(seg1);
                int d2 = getDistance(seg2);
                if (d1 == d2) return seg1.x - seg2.x; // same distance, ascending order
                return d2 - d1; // disteance discending order
        });
        seg.add(new Point(-1, num));
    }
    
    public int seat() {
        Point segment = seg.pollFirst();
        int left = segment.x;
        int right = segment.y;
        int mid = getMid(segment);
        seat.add(mid);
        seg.add(new Point(left, mid));
        seg.add(new Point(mid, right));
        return mid;        
    }
    
    public void leave(int p) {
        int left = seat.lower(p);
        int right = seat.higher(p);
        seg.remove(new Point(left, p));
        seg.remove(new Point(p, right));
        seat.remove(p);
        seg.add(new Point(left, right));
    }

    public int getDistance(Point p){
        int mid = getMid(p);
        if ( p.x == -1 )  return p.y - mid;
        if ( p.y == num)  return mid - p.x;
        return Math.min( p.y - mid, mid - p.x); 
    }
    
    public int getMid(Point p){
        if ( p.x == -1 ) return 0;
        if ( p.y == num) return num - 1;
        return p.x + ( p.y - p.x) / 2;
    }
}
