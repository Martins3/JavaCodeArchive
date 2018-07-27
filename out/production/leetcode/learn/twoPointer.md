## two pointer

1. 两个pointers从头往后走：感觉绝大多数的linked list的题目都涉及到这个操作，当然还有array。这类题目很多时候又可以称为sliding window。

●Implement strStr()   
●Longest Substring Without Repeating Characters   
●Minimum Window Substring   
●Remove Duplicates from Sorted Array & II   
●Remove Duplicates from Sorted List & II   
●Remove Element   
●Remove Nth Node From End of List   
●Reverse Linked Llist II   
●Rotate List   
●Substring with Concatenation of All Words   
●Swap Nodes in Pairs   

2. 两个pointers从两头往中间走：一般面试出现的的都是singly linked list, 因此这类题主要是array题。

●3Sum   
●3Sum Closest   
●4Sum   
●Container With Most Water   
●Sort Colors   
●Trapping Rain Water   
●Two Sum   
●Binary search (will discuss it in a separate section)   

3. 两个pointers控制两个不同的数组或链表：
一般出现在跟merge相关的题目上。  

●Add Binary   
●Add Two Numbers   
●Merge Sorted Array   
●Merge Two Sorted Lists   
●Multiply Strings   
●Partition List  

---
找到一个最小的区间，包含这个数列中出现的所有元素。这类连续的区间问题，很多都可以用这种尺取法线性的扫描。所谓的“尺取法”，就是维护两个指针，指向当前维护的区间的首和尾。维护是贪心的去尽量的缩小区间范围。比如这题就是要保证区间的首元素只出现了一次，否则就把首指针后移。当区间内不同元素的个数小于总个数，就把尾指针后移。
```
#include<cstdio>  
#include<cstring>  
#include<cmath>  
#include<vector>  
#include<queue>  
#include<iostream>  
#include<algorithm>  
#include<set>  
#include<map>  
typedef long long LL; 
using namespace std; 
const int maxn = 1000000 + 5; 
  
map<int,int> M; 
set<int> S; 
int a[maxn]; 
  
int main(){ 
    int p; 
    while(scanf("%d",&p) != EOF){ 
        S.clear();  
        M.clear();  
        for(int i = 0;i < p;i++){  
            scanf("%d",&a[i]);  
            S.insert(a[i]);  
        }  
        int n = S.size();  
        if(n == 1){  
            printf("1\n");  
            continue;  
        }  
        int ans = p;  
        int s = 0,t = 0,sum = 0;  
        while(s < p && t < p){  
            if(M[a[t]] == 0) sum++;  
            M[a[t]]++;  
            while(M[a[s]] >= 2){  
                M[a[s]]--;  
                s++;  
            }  
            if(sum == n){  
                ans = min(ans,t-s+1);  
                if(M[a[s]] == 1) sum--;  
                M[a[s]]--;  
                s++;  
            }  
            t++;  
        }  
        printf("%d\n",ans);  
    } 
    return 0; 
}
```




