class Solution {
    public int numFriendRequests(int[] ages) {
        // check param
        if ( ages == null || ages.length == 0 ) return 0;
        
        int sum = 0;
        int num = 0; 
        int cnt = 1;
        int target = 0;
        Arrays.sort(ages);
        // System.out.printf("after sort, ages = %s\n", Arrays.toString(ages));
        for ( int i = 0; i < ages.length; i++ ) {
            target = (ages[i] - 7) * 2;
            num = 0; 
            cnt = 1;
            for ( int j = i + 1; j < ages.length && ages[j] < target; j++ ) {
                if ( ages[j] == ages[i] ) 
                    cnt++;
                else
                    num++;
            }
            sum += cnt * (cnt - 1) + cnt * num;
            i++;
            while ( i < ages.length && ages[i - 1] == ages[i] ) i++;
            i--;
        }
        return sum;
    }
}
