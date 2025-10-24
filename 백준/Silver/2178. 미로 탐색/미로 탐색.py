"""
[BFS 활용]
1. 전체 maps, visited 선언(N x M)
2. x,y 증감
3. 칸마다 이동하면서 이동 칸수 더해서 갱신
   조건)
       1. maps 크기 벗어나지 않기
       2. maps == 1
       3. visited = False
- 문자열로 maps 받기
"""

import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())

maps = [[0]*(M+1) for _ in range(N+1)]
for j in range(N+1):
    if j == 0:  str = '0'*(M+1)
    else:       str = '0' + input()
    for i in range(M+1):
        maps[j][i] = int(str[i])

q = deque()
visited = [[False]*(M+1) for _ in range(N+1)]
q.append((1, 1))
visited[1][1] = True

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
while q:
    y, x = q.popleft()
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 1<=nx<M+1 and 1<=ny<N+1 and maps[ny][nx] == 1:
            if not visited[ny][nx]:
                visited[ny][nx] = True
                q.append((ny, nx))
                maps[ny][nx] = maps[y][x] + 1

print(maps[N][M])