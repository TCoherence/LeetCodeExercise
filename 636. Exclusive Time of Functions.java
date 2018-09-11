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

// Redo 
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if ( logs == null || logs.size() == 0 ) return null;
        
        int[] res = new int[n];
        int lastTime = 0;
        Stack<Integer> stack = new Stack<>();
        for ( String log : logs ) {
            String[] str = log.split(":");
            // 
            // System.out.printf("before : res = %s\n", Arrays.toString(res));
            //
            if ( str[1].equals("start") ) {
                if ( stack.isEmpty() ) {
                    lastTime = Integer.valueOf(str[2]);
                    stack.push(Integer.valueOf(str[0]));
                }
                else {
                    int preId = stack.peek();
                    int id = Integer.valueOf(str[0]);
                    int time = Integer.valueOf(str[2]);
                    res[preId] += time - lastTime;
                    lastTime = time;
                    stack.push(id);
                }
                
            }
            else { // str[1].equals("end")
                int time = Integer.valueOf(str[2]);
                res[stack.pop()] += time - lastTime + 1;
                lastTime = time + 1;
            }
            
            // System.out.printf("after : res = %s\n", Arrays.toString(res));

            // System.out.printf("%d\n", Integer.valueOf(str[0]));
        }
        return res;
    }
}
