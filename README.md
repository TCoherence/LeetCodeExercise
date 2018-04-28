# LeetCodeExercise  
[TOC]  
Records, summary and experience during doing leetcode. Mainly for future review. 
主要用于记录自己刷题过程中所写的代码，以便以后复习。目前2018-4-17 一刷开始。加油
## First Review(2018-4-28)
### Algorithm
**1 BFS**：Breadth First Search  
Queue(FIFO)
first node enqueue
while( !queue.empty() ){
  dequeue()
  check node around the dequeued node
  enqueue( non-checked around the dequeued node)
}  
**2 DFS** Depth First Search
Stack(FILO)
first node push in
while( !stack.empty() ){
  if ( near node is while ) // non checked
    push in stack and color to grey
  else
    pop 
}  
**3 KMP && BM** used to match two Strings
[KMP Algorithm](https://blog.csdn.net/qq_33583069/article/details/51922494) 
KMP利用公共前后缀进行跳转，其中next数组中,next[i]存储了第i个字符失匹配时，应该跳转到的字符串位置，且i>next[i],即一定往前跳，也就意味着模式串在往后移。
而文中提到的BM的 “坏字符规则” 和 “好后缀规则” ：  
```
坏字符规则：当文本串与模式串失匹配时，移动位数 = 当前模式串所匹配的位置 i - 失匹配字符在模式串中的位置 j(如果没有则 j = -1)
好后缀规则：当文本串与模式串失匹配时，移动位数 = 好后缀在模式串中的位置 - 好后缀在模式串中前一个出现的位置，若无则为-1
```
**4 Dynamic Programming**

  
**5 Greedy Algorithm**

### Problem
Problem | Notes
:-:|:-
22 Generate Parentheses  |backtracking基础题，29号多做几道来熟悉.
136 Simple Number  |异或操作
137 Simple Number II | 利用bit出现次数当作状态转移。其中重要的是，保留某一个位的某个次数为1.
100 Same Tree ;104 Maximum Depth of Binary Tree |**recursive**
88 Merge Sorted Array |直接从后面往前面放.
70 Climbing Stairs | DP 基础题
53.Maximum Subarray | 遍历数组，初始maxsum = integer.MIN_VALUE, update maxsum = Math.max(sum, maxsum)保证一直最大。
4.Median of Two Sorted Arrays| 要求O(log(n+m)),利用Median的property, divide into 2 groups and the max in the left is lower or equal to the min of the right.
29.Divide Two Integers (Medium) | 因为题目要求不能用乘除余的方法，所以利用bit移动实现二分的功能。迅速定位。基础算法还是辗转相除法。
1.Two Sum | sorted之后遍历O(nlogn)+O(n/2) ~ O(nlogn) 能够达到O(n),29号想想。
7.Reverse Integer|
3.Longest Substring Without Repeating Characters|
