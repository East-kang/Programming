import sys
input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]

for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

visited = [False]*(N+1)
count = 0
stack = []
for i in range(1, N+1):
    if not visited[i]:
        stack.append(i)
        visited[i] = True

        while stack:
            v = stack.pop()
            for u in graph[v]:
                if not visited[u]:
                    stack.append(u)
                    visited[u] = True
        count += 1
print(count)