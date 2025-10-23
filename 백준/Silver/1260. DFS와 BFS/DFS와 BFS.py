import sys
from collections import deque
input = sys.stdin.readline

N, M, V = map(int, input().split())

maps = [[0]*(N+1) for _ in range(N+1)]
for i in range(M):
    a, b = map(int, input().split())
    maps[a][b] = maps[b][a] = 1

visited1 = [0]*(N+1)
visited2 = [0]*(N+1)

def dfs(V):
    visited1[V] = 1
    print(V, end = ' ')
    for i in range(1, N+1):
        if maps[V][i] == 1 and visited1[i] == 0:
            dfs(i)

def bfs(V):
    q = deque([V])
    visited2[V] = 1
    while q:
        V = q.popleft()
        print(V, end = ' ')
        for i in range(1, N+1):
            if maps[V][i] == 1 and visited2[i] == 0:
                q.append(i)
                visited2[i] = 1
dfs(V)
print()
bfs(V)