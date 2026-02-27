"""
[DFS 활용]
1. A,B,C,D,E의 관계는 깊이가 5인 관계
2. DFS 재귀를 5번 수행하면 1, 아니면 0 반
"""

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(s, depth):
    if depth>=5:
        print(1)
        exit()
        
    visited[s] = True
    for v in graph[s]:
        if not visited[v]:
            visited[v] = True
            dfs(v, depth+1)
    visited[s] = False

for i in range(N):
    visited = [False]*N
    dfs(i, 1)
print(0)