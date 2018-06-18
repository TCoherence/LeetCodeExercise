class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if ( target <= 0 ) return 0;
        if ( position == null || position.length == 0 || speed == null || speed.length == 0 ) return 0;
        int res = 0;
        int len = speed.length;
        double [][] car = new double[len][2];
        for ( int i = 0; i < len; i++){
            car[i][0] = position[i];
            car[i][1] = (double)(target - position[i]) / speed[i];
        }
        Arrays.sort(car, (a,b) -> Double.compare(a[0], b[0]));
        double curtime = 0;
        for ( int i = len - 1; i >= 0; i--){
             if(curtime < car[i][1]){
                 curtime = car[i][1];
                 res++;
             }
        }
        return res;
    }
}
