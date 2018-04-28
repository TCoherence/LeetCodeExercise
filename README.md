# LeetCodeExercise
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
其中BM的 “坏字符规则” 和 “好后缀规则” 暂时没有弄懂。  
**4 Dynamic Programming**

  
**5 Greedy Algorithm**

### Problem
22 Generate Parentheses  backtracking基础题，29号多做几道来熟悉。  
136 Simple Number  异或操作  
137 Simple Number II  利用bit出现次数当作状态转移。其中重要的是，保留某一个位的某个次数为1.  
100 Same Tree ;104 Maximum Depth of Binary Tree **recursive**  
88 Merge Sorted Array 直接从后面往前面放。
