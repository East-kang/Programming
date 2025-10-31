"""
[DFS 활용 문제]
: 연결된 정점의 정보를 요구함
1. 무방향 그래프 생성
2. 그래프의 첫 항목부터 dfs 수행
3. 방문한 노드는 방문 여부 갱신
"""

import sys
input = sys.stdin.readline
N, M = map(int, input().split())

# 1. 그래프 생성
graph = [[] for _ in range(N+1)]
for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

# 2, 3. DFS 수행
visited = [False]*(N+1)
stack = []
count = 0

for i in range(1, N+1):
    if not visited[i]:
        stack.append(i)
        visited[i] = True
        count += 1
        
        while stack:
            u = stack.pop()
            for v in graph[u]:
                if not visited[v]:
                    stack.append(v)
                    visited[v] = True
print(count)