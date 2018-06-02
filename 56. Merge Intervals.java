/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    /** 
    *   For each to-be-merged intervals( Our goal interval to be stored in the List returned ),  
    *   after sort it we will get several groups of interval and may change the old sequence, here is a example:
    *   [1,10],[2,3],[5,11]
    *   1---------------10
    *     2--3
    *           5---------11
    *   if we sort the start and end we have
    *   1---3
    *     2-------------10
    *           5---------11
    *   and it will be much easier to find the merged group because start and end are both ascending sorted. And then
    *   we could take use of this property and find if a new start is between the old interval or not. If it is true then we need 
    *   enlarge our old interval, but if not, then we add this interval to the List
    */
    public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; j < n; j++) { 
            // i is start of interval, use j to search new start
            // if a new interval is going to find or reach the end of the array
            if ( j ==  n - 1 || starts[j + 1] > ends[j] ){
                res.add(new Interval(starts[i], ends[j]));
                i = j + 1;
            }
        }
        return res;
    }
}
