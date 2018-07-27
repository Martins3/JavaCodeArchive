实验的样例我过段时间会给出来。。。
输入格式如下：
输入可能有多组数据，以EOF结尾，每组数据格式如下：
第一行四个正整数P、N、M、T。其中P表示有几次会面等待安排，N、M、T含义和题目相同。
接下来P行，其中第j行表示一次待安排的会面，格式如下：正整数u[j]、v[j]、w[j]，表示学生u[j]在时间点w[j]想见教授v[j]。

输出格式如下：
对于每组数据，输出可安排的最大会面数。

提示：
因为我也没写程序所以我也不知道给多大数据范围比较合适，暂定：
1 <= P <= 10000
1 <= N <= 100(student)
1 <= M <= 20(professor)
1 <= T <= 30(time)


输入所给的教授、学生、时间点的编号均从1开始（和题目描述相同）。
所有教授在时间点1~T都有空闲（即无视原题目描述中的Tj）。

对于要求a、b、c（不考虑一个学生只能见一个教授一次的情况下）：
输入：
4 2 2 4
1 1 2
1 2 1
2 2 1
2 1 2



4 2 2 2
1 1 1
2 2 2
1 1 2
2 2 1

输出：
2
2
4
↑改一下输入输出格式
删掉了教授在什么时候有空闲这个东西
改为所有教授在所有时间都有空闲


(experiment). Student-Professor Problem.
Given students 1,2,3...n,professor 1,2,3...m,
time slot 1,2,3...t.
For student i,specifies Pi = {(prof,time)pairs when the student can meet}.
For professor j,specifies Tj = {times when j is available}.
Our purpose is to schedule as many appointments (i,j,t) as possible.
Thinking about the practical use,we have following restrictions
(You can add more to make it more Appropriate):
a.If (i,j,t) is scheduled,(j,t)∈Pi.(创建联系)
b.If (i,j,t) is scheduled,then ∀i’ ≠ i,(i’,j,t) is not scheduled.
c.Student can not meet two professors at the same time.
(所有的见面都是一对一的实现)

d.Student do not want to meet a professor twice.
(不可以两次, 二分, 不可以的 ???)
Please solve this problem use max flow algorithm and
bipartite graph matching algorithm and compare there time complexity.


思路:
1. 获取路径的方法
2. 复用之前的部分 !
3. make the Graph !