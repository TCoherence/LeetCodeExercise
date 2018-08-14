class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stackIdx = new Stack<>();
        int lastTime = 0;
        for ( String log : logs ) {
            // System.out.printf("res = %s, lastTime = %d\n", Arrays.toString(res), lastTime);
            String[] str = log.split(":");
            if ( !stackIdx.isEmpty() ) res[stackIdx.peek()] += Integer.valueOf(str[2]) - lastTime;
            lastTime = Integer.valueOf(str[2]);
            if ( str[1].equals("start") ) {
                stackIdx.push(Integer.valueOf(str[0]));
            }
            else {
                res[stackIdx.pop()]++;
                lastTime++;
            }
            // System.out.printf("res = %s, lastTime = %d\n", Arrays.toString(res), lastTime);
            // System.out.println("");
        }
        return res;
    }
}
