1. Two Sum
/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

introspection：
失去了sorted这个条件就只会brute解决了，看了大神的解答发现可以用HashMap，可以尝试一下用HashMap解决。
When I lose the condition of array sorted, the only solution comes to my mind is brute solution and 
I totally forget HashMap I just have learned a few hours ago. More work need to be done.
*/

```java
// My first brute solution:  33ms

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return null;
        
        int len = nums.length;
        for(int i = 0; i < len; i++){
            for ( int j = i+1; j < len; j++){
                if(nums[i] + nums[j] == target ) return new int[]{i,j};
            }
        }
        return null;
    }
}

// After using HashMap:  8ms
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) return null;
        int[] ret = new int[2];
        int len = nums.length;
        // Key--nums[i], Value--index_i
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for( int i = 0; i < len ; i++){
            if(hashmap.containsKey(target - nums[i])){
                ret[0] = hashmap.get(target - nums[i]);
                ret[1] = i;
                return ret;
            }
            else{
                hashmap.put(nums[i],i);
            }
        }
        return ret;
    }
}
```
