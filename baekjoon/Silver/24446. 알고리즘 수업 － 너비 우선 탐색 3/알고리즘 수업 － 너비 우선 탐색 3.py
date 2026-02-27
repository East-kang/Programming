"""
[BFS 활용 문제]
1. depth를 -1로 초기화
2. 루트 노드의 depth에 +1
3. (자식노드 depth) = (부모노드 depth) + 1
"""
import sys
from collections import deque
input = sys.stdin.readline

N, M, R = map(int, input().split())

maps = {i: [] for i in range(1, N + 1)}
for i in range(M):
    u, v = map(int, input().split())
    maps[u].append(v)
    maps[v].append(u)

depth = [-1]*(N+1)
visited = [False]*(N+1)
q = deque()
q.append(R)
visited[R] = True
depth[R] += 1

while q:
    v = q.popleft()

    for u in maps[v]:
        if not visited[u]:
            visited[u] = True
            q.append(u)
            depth[u] = depth[v] + 1

for i in range(1, N+1):
    print(depth[i])