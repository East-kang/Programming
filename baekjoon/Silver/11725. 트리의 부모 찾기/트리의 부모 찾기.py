"""
[트리, DFS]
1. 노드 1부터 dfs를 활용
2. 탐색하면서 다음 노드의 부모 노드를 현재 노드로 설정
"""

import sys
input = sys.stdin.readline

N = int(input())
graph = dict()
for _ in range(N-1):
    u, v = map(int, input().split())
    if u not in graph:
        graph[u] = []
    if v not in graph:
        graph[v] = []
    graph[u].append(v)
    graph[v].append(u)

ans = [0]*(N+1)
stack = []
visited = [False]*(N+1)
stack.append(1)
visited[1] = True

while stack:
    u = stack.pop()
    for v in graph[u]:
        if not visited[v]:
            visited[v] = True
            stack.append(v)
            ans[v] += u
for i in range(2, N+1):
    print(ans[i])