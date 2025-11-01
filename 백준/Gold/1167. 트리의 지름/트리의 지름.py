"""
[DFS 활용]
1. 임의의 점부터 출발해 가장 먼 지점으로 이동 (bfs 1st)
2. 이동한 점부터 가장 먼 지점으로 이동 (bfs 2st)
"""

import sys
input = sys.stdin.readline
from collections import deque

V = int(input())
graph = [[] for _ in range(V+1)]
for _ in range(V):
    arr = list(map(int, input().split()))
    n = len(arr)
    for i in range((n-2)//2):
        graph[arr[0]].append((arr[i*2+1], arr[(i+1)*2]))

q = deque()
def bfs(s):
    distance = [-1]*(V+1)
    distance[s] = 0
    q.append(s)

    while q:
        v = q.popleft()
        for u, w in graph[v]:
            if distance[u] == -1:
                q.append(u)
                distance[u] = distance[v] + w
    m = max(distance)
    return [distance.index(m), m]

print(bfs(bfs(1)[0])[1])