---
title: LeetCode Exercise
date: 2018-05-06 23:20:50
tags: LeetCode
---

# **Leetcode**
> This is a temporary file to record the experience of doing leetcode and will be rewrite and rearrange the layout (Typesetting) ASAP.  
> 2018.5.6

# 2018-4-10
Array Partition I    
Arrays.sort，是Arrays！

Max Consecutive Ones   
都说了是Consecutive ones还在考虑连续的0，不知道题目到底看没。

Toeplitz Matrix    
关键是对角，不一定要分组的。

Move Zeroes    
又是低级错误。。。。数组数值被下标代替。。。。

week 5
In in = new In(args[0]);
&&语句前后顺序很重要！
if( x.lb != null && rect.intersects(x.lb.rect) )
=if( x.lb != null ){

    if(rect.intersects(x.lb.rect)
}
所以一旦反过来变成这样就会出问题，因为x.lb可能为Null
rect.intersects(x.lb.rect)  && x.lb != null

nearest 是x.lb或者x.rt的rect的判断而不是对x.rect的判断

# 2018-4-11
今天看了两个算法:
BFS ： Breadth-First-Search
DFS： Deapth-First-Search

BFS: 采用FIFO结构

顶点进队列
while（队列非空）{
    把周围的未经过的顶点进队列。
    出队列。
}
结束循环，遍历所有节点。

DFS：栈

先把所有节点标白
顶点进栈，将其标灰
while(栈非空）{
    if（邻节点有白）{

    节点标灰色

进入节点，将其压栈。
    }
    else （邻节点无白）{

    将该点出栈
    }
    
    
}


# 2018-4-16
现在准备看KMP算法，在回文算法题的discussion中看到。、

# 2018-4-17
复习week1 内容，Topological sort是redraw DAG so all edge point upwards.1) DFS, 2) return vertex in postorder

脑子不清醒了：
1、数组元素居然用 [ ] 括起来；
2、数组长度是num.length不是num.length{}
3、二分法的判断条件是high >= low，有一个等于号！！！

① 167. Two Sum II - Input array is sorted
sort 二分法还是不如两头相加来的方便。两头相加真是太牛逼了。
要注意的几个点是 int相加溢出，用long存储。判断参数。

② 169. Majority Element
自己第一反应是简单粗暴的创建一个65536数组，直接存储，两次for进行brute serach
想想有没有更好的方法
看了discussion：
1、牛逼，充分利用了major element数量大于一半，直接对数计数，遇到就加，碰到就减，最后留下来的肯定是major element
2、bit操作，很神奇。但是不知道为什么能够得到正确的结果。
3、hash table，暂时没学过，明天学习。
4、sorting，直接获取中间位数字即可 

③ 448. Find All Numbers Disappeared in an Array
第一反应： sort之后，根据offset计算disappear的值
看了discussion：
1、利用数组元素作为索引标记。核心在于数组中的元素个数和最大的数是相同的，也就是都是n。我之前以为可以小于n所以一直觉得很有问题。重点还是要好好审题啊。总是有小问题。
得到思路之后自己写，又出现了小问题：写出了List<int>。。。emmm多注意小细节。

提交之后发现有时间更短的，果然用了额外数组空间。

④ 717. 1-bit and 2-bit Characters
很简答的一道题目。。。emmm就是低级错误还是有:
1、变量都没声明就开始用了。
2、if语句乱用 。。。
3、大思路正确但是细节方面还是有瑕疵，跳跃检查没事但是忽略了最终都会跳到同一个位置。。

⑤ 121. Best Time to Buy and Sell Stock
思路很清晰的一道题目，但是自己还是考虑不够。
1、先入为主，没有考虑多种可能，认为只有一种可能，所以直接判断左边最小和右边最大。致使[2,4,1]这种testcase都output = 0，（因为左边最小是1所以 1 - 1 = 0）

刚刚看了 Best Time to Buy and Sell Stock II，听说要用贪心算法，没有接触过，明天对其进行了解。

# 2018-4-18
① 128. Longest Consecutive Sequence (有问题，没有达到O(n) 的要求却AC 100)
要求O(N)，所以第一反应就是sort之后直接go through，O(n)+O(nlogn),不知道这算不算O(n)....数量级上是一样的。
提交后居然第一次AC 100，卧槽。。。。
尽管如此，第一次提交忽略的一个corner case，就是都是consecutive的时候，就不会执行到else语句当中。这个要多注意。
★ if-else语句要注意是否都会执行到。

② 217. Contains Duplicate
sort之后直接判断。发现自己已经迷上了sort【然而好像时间复杂度。。。。】

③ 268. Missing Number
sort之后 go through或者二分查找

看了discussion发现，有两个灵性的解法，但是比较特殊，因为只能找到少一个的
1、SUM操作，然后减array
2、XOR操作，因为a^b^b = a，所以将1 ~ n 所有与array中的所有XOR，就能得到missing number

④ 661. Image Smoother
第一反应还是brute 解决。
看完discussion，似乎大多也是brute。
但是有一个厉害的老哥，利用了255是8bit，int是16bit，将前8bit作为计算结果存储，最后整体右移8位！！！强的一笔，节约了一倍的空间。
反思：
1、自己边界判断都能弄错，服了。真是不知道在干嘛。。。。
2、循环变量居然忘记初始化？？？？

⑤ 628. Maximum Product of Three Numbers
很奇怪，为什么sort之后直接计算的速率还不如不算的速率？因为时间复杂度不同。

⑥ 746. Min Cost Climbing Stairs
go through, i处判断i+1, i+2

第一次提交出错，[0,0,0,0]
很玄学，因为判断顺序的问题，先进行了计算后进行了判断，所以先出界，然后判断。抛出异常
第二次提交出错，[0,2,2,1]
改成两头运算，但是感觉很虚，方法冗长。

思路完全错误，应该动态规划。贪心算法似乎有问题。还是没有搞懂贪心算法和动态规划的区别。这道题目先放一放吧。把这两个算法弄懂了再来做。

⑦ 697. Degree of an Array
思路:
go through array, 统计value（degree），first_index，last_index
然后计算degree，和minimum_length
时间复杂度
go through -- O(n)
    统计，链表的话就是O(n), hashmap/hashtable 是 O(1)
计算degree， go through O(n)

引出hashmap和hashtable的区别问题。


-------------------------------------------------------------------------------------------------
重新规划，先刷1-300.

1. Two Sum
失去了sorted这个条件就只会brute解决了，看了大神的解答发现可以用HashMap，可以尝试一下用HashMap解决。

2. Add Two Numbers
easy,设置res和carry两个数分别记录加后%10的值和进位，然后判断l1,l2是否为同时为null为结束循环条件。
但是忽略了同时为null时也有可能carry = 1，导致错误。
同时计算res加了c，计算c的时候却没有，同样导致错误。多加小心。

3. Longest Substring Without Repeating Characters
两个index，一个头一个尾，hashmap存储，一旦tail发现重复，回溯到重复点，重新查找，并且保存当前maxlen
思路正确，但是很遗憾，代码编写错误还是很多。
值得注意的是
1、s.length() 和 a.length String的length是带括号的，而数组不带。
2、找s中对应下标的char是s.charAt(index),而数组直接a[index]即可
3、
原始类型   封装类
boolean      Boolean
char           Character
byte           Byte
short          Short
int              Integer
long           Long
float           Float
double      Double
4、遇见if-else一定要多加注意，看有没有可能一直if或者一直else导致某些特定语句没有执行到。。。。


# 2018-4-20
7. Reverse Integer
第一反应，boolean sign保留符号，然后abs计算，改成string，逆序，改回long int，输出。
还是太复杂了，直接从尾部go through，但是overflow有一个很奇妙的地方，x / 10 != a即可证明其overflow（https://leetcode.com/problems/reverse-integer/discuss/4060/My-accepted-15-lines-of-code-for-Java/126400?page=1）
java int是32bit

9. Palindrome Number
和7一样计算出值直接 ==，而且如果入参 <0 直接返回false

13. Roman to Integer
找最大值，然后go through，小于最大的index做减法，大于的做加法。
仍然有漏洞，最大的可能多次出现。且多次出现仅有可能在头部。


21. Merge Two Sorted Lists
题目根本没有说要保持sorted。。。
改了之后过了

20. Valid Parentheses
利用stack，检查。但是时间花费较多，似乎用数组更快，这是为什么呢？


29. Divide Two Integers (Medium)
这种数据的edge case一定有overflow！！！！
java中 int cannot be converted to boolean

# 2018-4-21 （29今天也把他弄懂。）
38. Count and Say
递归计算，时间开销很大。
学习其他人的方法。
1、利用循环调用函数进行计算，能用循环尽量用循环，因为递归在不断开销新的资源，每一次调用都会产生新的资源，而循环能够尽量再同一空间上进行计算，能够减少资源的开销。
2、char[] 与 String之间的变化，String有个toCharArray()变成char数组，所以没必要每次都用s.charAt(index)来读取char
3、新学到StringBuilder类
4、数组长度length，字符串长度length()
5、改为循环，仍然没有利用StringBuilder，发现时间开销依旧很大，改为Stringbuilder之后瞬间提升，原因是什么呢？
这是因为String的长度大小是不可变的，当我们进行拼接的时候重新创建了一个新的String类型数据，所以不断的循环导致不断的开销。而StringBuilder的长度是可变的，所以一直在同一个内存空间操作，速度大大提升。如下图所示


String 长度大小不可变
StringBuffer 和 StringBuilder 长度可变
StringBuffer 线程安全 StringBuilder 线程不安全
StringBuilder 速度快

35. Search Insert Position
easy binary search

26. Remove Duplicates from Sorted Array
easy index increase to go through. duplicates is invalid and can be overwrited


27. Remove Element
same way as 26 but no need to check index == len - 1. just record the number of deleted elements.


29. Divide Two Integers (Medium)
采用brute方法直接exceed time limit,很难受。看看别人怎么做的吧    
1、擦，被秒杀。。。这个bit 操作真的很骚。。。而且我记得之前也有一道题目涉及到了bit操作。
2、其实对divisor进行自加加然后对其结果再次自加，也有移位的效果。
所以其实就是耍了一个trick，说不能用乘除和mod，就利用移位达到快速定位的效果，这个其实也相当于 go through和二分的区别。    


13. Roman to Integer
右有大，负加。
右无大（碰边界），正加。
思路完全正确，之前居然没有想到。
但是发现了新的问题：
Java中 Hashmap性能上似乎不如switch语句，原因暂时不知道，只看到了几个关键词：JVM, tableswitch, Lookupswitch, HashMap自己的构造函数中默认构造大小。


14. Longest Common Prefix
其实是一道没有太大意思的题目，思路清晰，仅仅锻炼一下自己码代码的细节的问题：
1、charAt是函数，用的（）括号而不是 [] 
2、char[][] 是不存在的。只有char[]
3、一定要注意自己的for循环里面，是否将 i 写成了常数


# 2018-4-21
4. Median of Two Sorted Arrays（）
要求是log(m+n)
重点是弄懂median的作用，其作用是分割成两个部分，左边最大小于右边最小。且左右大小相等。所以基于这个亮点对其中一个进行binarysearch，然后另外一个因为要保持大小相同，所以也在同时binarysearch，达到log的效果。
尽管如此，原理还是没有完全弄透彻。Hard果然是Hard。。。
需要反复复习。



53. Maximum Subarray
直接遍历整个数组，从第一个大于0开始，sum进行累加，
if    sum >= 0 i++,maxsum = Math.max( maxsum, sum),
else sum < 0, i++, sum = 0; maxsum = Math.max ( maxsum, sum);
O(n) 时间复杂度。
说可以用分治的方法 divide and conquer, 开始学习怎么做。
如果按照我刚刚从大于0的开始，要出问题。因为可能全为负值，导致出错。
思路还是正确的，看完讨论发现大家都是O(n)的时间复杂度。
我的思路上是遍历，但是用到了分治的思想，但是自己没有看出来。
分：i 遍历，寻找前 i 个sum最大的。
治：根据第 i - 1 个情况，若小于0，清零计算，大于0，不作改动。然后加nums[i],然后与前一时刻最大值比较。其实这里sum 相当于状态，maxsum就是历史。

58. Length of Last Word

66. Plus One



69. Sqrt(x)
耍了一个trick，直接从Integer.MAX_VALUE的平方根开始算。

70. Climbing Stairs

83. Remove Duplicates from Sorted List
easy，但是实现过程中还是有小问题：
1、没有判断是否相同直接跳到下一个节点导致：【1,1,1,1,1】处理完变成了【1,1,1】。因为第二个处理完之后跳到了第三个，处理完第四个跳到第五个。。。。

88. Merge Sorted Array
虽然不可以从最小的开始，但我们可以从最大的开始啊。


67. Add Binary
StringBuilder 可以append不同类型的，不一定要char型。而且可以不同类型组合。

104. Maximum Depth of Binary Tree

100. Same Tree


136. Single Number
这个还是简单的，毕竟两个相同的数字进行异或即可。

137. Single Number II
这个就很难受了，弄了一个晚上。感受到了自己的菜鸡。
利用状态转移，设置不同状态表示接收到了不同的bit个数，因为某一个，数字的固定位置比特肯定是只出现一次的。
所以只要弄一个只有固定比特为1的状态，其余以方便优先选择。

260. Single Number III
位运算，求反，本来和原来的数完全相对，相与变成0，但是加1之后，能够找到最右不同的比特，也可以说从低到高第一个不同的bit
解释如下：
        s1 a1 b1 c1
        s2 a2 b2 c2
^      —————

        s   a   b   c
取反 s_ a_  b_ c_

        —————
        ①c = 1,说明c1 c2 不同
        ②c = 0,说明c1，c2相同，则c_ = 1，
        ③+1之后，将进位，也就等同于+1到b，继续①②两步
    after find the rightest bit, then we diff & -diff, we can make the bits lower than the rightest bit to zero, the rightest will be '1' and those bits higher than the rightest will be '0' because of ~ operation

12. Integer to Roman
easy


273. Integer to English Words
easy


6. ZigZag Conversion
找规律题目

22. Generate Parentheses
backtracking题目，但是属于easy的范围，仍然没有完全弄懂backtracking的原理，明天可以找backtracking题目进行熟悉。


125. Valid Palindrome
easy，没有太刁难。首尾移动判断即可。


680. Valid Palindrome II
多了一个简单的判断。

112. Path Sum
思路还是很清晰的，但是在代码实现过程仍然要注意几个问题：
1、参数可以是null，但是不能对null进行操作，所以在对参数进行操作时要注意是否为null，尤其当对多个参数进行判断的时候。因为自己总是仅判断一个情况，那就是全为null的情况。


101. Symmetric Tree
这里居然出现了一个低级错误——对节点本身进行判断，而不是其中的值。。。


# 2018-4-29

141. Linked List Cycle
可以利用head作为标志，全部指向head，如果有一个节点已经指向了head说明了有loop，但是这样会破坏原来的数据结构。若要copy古来又无法满足without using extra space
2、brilliant，利用walker和runner，一个走一步一个走两步，如果loop肯定能相遇，如果到了末端没相遇则没有！


784. Letter Case Permutation
backtrack 练习题，慢慢摸到了一点点门路。
现在对其理解就是
建立一个helper用于递归调用:

```
helper(...){
    if ( i < len ){
        if(isValid) 
            go left;
            some operations;
            go right;
        else back to i-1(return )
    }
    else{
        store;
        return;
    }
}
```

142. Linked List Cycle II

很遗憾，自己的方法还是不如别人的方法。


l1 = the distance from head to the node where cycle begins
l2 = the distance from the node where cycle begins to the node where walker and runner meet
l3 = the distance from the node where walker and runner meet to the node where cycle begins.
when first meet, we have
l1+l2 = (l1+l2+l3+l2) / 2, because the time used is the same
so l1 = l3.

46. Permutations
也算是知道了自己的错误了。思路没有错误，但是数据处理上出现了问题，因为lastres是重复使用的，当我add的时候一直加的同一个地址，所以最后在remove掉的时候把lastres所对应的空间数据全部remove掉导致没有任何数据了。


17. Letter Combinations of a Phone Number

47. Permutations II
感觉很有代表性的一道题目，做出了这个题目之后其他的duplicate几乎有迎刃而解了。
78. Subsets

77. Combinations

39. Combination Sum


40. Combination Sum II

216. Combination Sum III

526. Beautiful Arrangement
真的很强，从头遍历和从尾部遍历得到不同的branch，而从尾部能够更快的过滤掉无用的东西。难怪是medium。

# 2018-5-2
48. Rotate Image
思路清晰，但是代码编写上还有漏洞，比如
内外循环变量，内 j 外 i
应该是i <= len/2 写成了 i < len/2，而且 j也写成了 j < len/2，本应该是 j < len-1-i。。。。emmm这个问题的出现，主要还是自己从思路到代码方向上不能够有效的联系起来。
1、首先采用递归
```java
/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) { val = x; }
* }
*/
class Solution {
    public ListNode swapPairs(ListNode head) {
        if ( head == null ) return null;
        ListNode Head = new ListNode(0);
        Head.next = head;
        swap(Head, head, head.next);
        return Head.next;
    }
    public void swap(ListNode head, ListNode node1, ListNode node2){
        if ( node1 == null || node2 == null ) return;
        node1.next= node2.next;
        node2.next = node1;
        head.next = node2;
        swap(node1, node1.next, node1.next.next);
    }
}
```
知道问题在哪里了，当node1.next已经是null的时候，node.next.next就要出问题了，因为null是没有next的，此时就会爆出NPE错误。更改后如下：
```java
class Solution {
    public ListNode swapPairs(ListNode head) {
        if ( head == null ) return null;
        ListNode Head = new ListNode(0);
        Head.next = head;
        if ( head.next == null ) return;
        swap(Head, head, head.next);
        return Head.next;
    }
    public void swap(ListNode head, ListNode node1, ListNode node2){
        node1.next= node2.next;
        node2.next = node1;
        head.next = node2;
        if ( node1.next == null || node1.next.next == null ) return;
        swap(node1, node1.next, node1.next.next);
    }
}
when( lo < hi){
    mid = (lo+hi) / 2;
    if ( nums[mid] < nums[low] ) high = mid - 1;
  else low = mid;
}
```
24. Swap Nodes in Pairs
1、函数可以接受null参数。
2、不能对null参数进行操作——也就是说，在链表中，head.next = null时，不能调用head.next.next；否则就是NPE错误。很关键。所以这个决定了是进了函数体之后再做判断，还是先判断再进函数体。

19. Remove Nth Node From End of List
保留头部，以n长度窗口移动，到tail时铲除head.next；

33. Search in Rotated Sorted Array
很难受，其实思路一样，但是代码就是写着有问题。讲道理的话，找到最大值和找到最小值进行计算都一样。但是为什么最大值就无法正确的找到呢。。。
！！！！！！
很有意思的一道题目，帮我解决了BS的核心问题。
a_lo, a_mid, a_hi。前面之所以找最大值不能够正确的找到，问题出在最后一步。因为二分法无论如何最后总会变成
a_lo = a_mid， a_hi.
此时如果采用寻找最大值，就无法满足a_lo和a_mid是独立开的，导致之前一直依赖的逻辑出错。（因为不再满足这个逻辑）
而如果是采用寻找最小值，就能够满足a_mid和a_high是独立开的，最终找到正确的值！！
总结为两点：
1、选择mid与high比较，不可选择mid与low比较
2、此时因为low high 有可能等于mid，若循环判断条件为 low <= high会出现 low一直等于high的死循环，应该改为low < high

34. Search for a Range
先二分找到一个值，再在其左右二分寻找（是否需要左右寻找通过一个简单的左右值判断即可）

43. Multiply Strings
也算比较蛋疼的一个题目吧，主要还是一些corner case的考虑不够周全。
1、没考虑到"0"
2、学到了String之间比较如果直接 ==比较是引用比较，比较的是地址，要比较内容需要用到equal函数

2018-5-3
61. Rotate List
又是一道rotate的题目，可以利用rotation的特性直接得到newhead和newtail的位置。但是要留一个HEAD定位真正的头的位置。

344. Reverse String
学到了String.valueOf()
``` java
class Solution { 
    public String reverseString(String s) { 
        char[] c = s.toCharArray(); 
        int l = c.length-1; 
        int mid = (l+1)/2; 
        char t; 
        for(int i=0; i<mid; i++){
            t = c[i];
             c[i] = c[l-i];
            c[l-i] = t;
            } 
        return String.valueOf(c);
    }
}
```
# 2018-5-4
557. Reverse Words in a String III
两个新函数需要学习：
String下的split，StringBuilder下的trim()

# 2018-5-4
191. Number of 1 Bits
学到了一个小技巧。。。
>">>>"是logic shift

190. Reverse Bits
思路没错。。。然而没想到是32bit，只做了有效位的reverse，高位的0刚刚开始没有reverse

231. Power of Two


# 2018-5-5
155. Min Stack
我是按照之前coursera里面做的啊，为什么时间效率这么低，可能是数组空间变化的原因，但是原Java里面的Stack类不是吗？待会了解一下；

172. Factorial Trailing Zeroes
自己总是陷入brute force的思路，很难受。。。
但是自己想到了5，没有仔细的深挖，或者说自己境界不够吧，居然在想着怎么凑2和5来算10的个数。。。其实只要看5就行了。

189. Rotate Array
for those elements in the range of [n-k, n-1], they need to move to (i+k) % n, and when i+k is in the range of [n, 2n), we have (i+k) % n = i+k-n;
for those elements in the range [0, n-k-1], they need just move to (i+k)
like below:
0      n-k-1 n-k        n-1
[                |                  ]    a1
    range1     range2
Thus, when we first reverse the whole array, we have the ist element in the new array which equals n-i-1, and now we have
0          k-1 k        n-1
[                |                  ]    a2
    range2     range1
so when we reverse the first part of the new array a2(range2), the ist element in the new array part will be k-1-(n-i-1) = k+i-n and this is exactly what we need, the same as the second part after the reversion.

198. House Robber
easy DP solution but used O(N) space; it seems like there is a O(1) Space solution

# 2018-5-6
11. Container With Most Water
while(left < right){
    if nums_left < nums_right left++;
    else right--
    update max
}
return max;

80. Remove Duplicates from Sorted Array II
if-else problem happens again, when it comes to if-else branches, YOU NEED TO CHECK IF THE CORNER CASE THAT ONLY IF OR ELSE BRANCH IS APPROACHED.

532. K-diff Pairs in an Array
I do it by simple search like brute solution.
However, there are some more efficient solutions like Two Pointers or HashMap, the latter is more understandable but the former is a little hard to understand fully

class Solution {
    public int findPairs(int[] nums, int k) {
        if(k < 0) return 0;
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 0, j = 1; j < nums.length;  ){
            if(i >= j || nums[i] + k > nums[j]) j++;
            else if( i > 0 && nums[i] == nums[i - 1] || nums[i] + k < nums[j]) i++;
            else{
                ans++; i++;
            }
        }
        return ans;
    }
}
Figure it out but don't know how to come up with the idea.

209. Minimum Size Subarray Sum
two pointer i and j, sum to store the sum of subarray
for i,j = 0; j <= nums.length;
if ( sum >= s ) {
    update minlen;
    sum -= nums[i]; i++; 
}
else{
    if( j == nums.length ) break; // j comes to the end and the increment of i will never enlarge the sum. so break;
    sum += nums[j];
    j++;
}

75. Sort Colors
someone posted four different solution...omg...
What a huge 
My idea:
sort 0 then sort 1. two pass.
don't know the one pass solution...
① Insertion solution
Explanation: restore the last index of 0, 1, 2 and when it comes a new num, we insert it and increment the corresponding index, eg insert 0, increase index of 0,1,2 but if insert 2 we only need to increase the index of 2.
n0,n1,n2
for( i from 0 to nums.length){
    if nums[i] = 0
        nums[++n2] = 2;
        nums[++n1] = 1;
        nums[++n0] = 0
    else if
    else 
}


