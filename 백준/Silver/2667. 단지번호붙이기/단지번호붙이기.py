"""
<BFS 활용>
1. 전체 집 순회
2. 상하좌우 중 1이 겹쳐진 곳 방문, 시작점 0으로 값 변경
3. 큐 비어지면 단지 수 증가
4. 전체 maps 총합이 0이면 종료
5. 단지 수 정렬해서 출력
"""

import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
maps = [[0]*N for _ in range(N)]
for j in range(N):
    str = input()
    for i in range(N):
        maps[j][i] = int(str[i])

q = deque()

dx = [-1,1,0,0]
dy = [0,0,-1,1]
Y, X = 0, 0
ans = []
while X<N and Y<N:
    if maps[Y][X] == 0:
        if X == N-1:
            X = 0
            Y += 1
        else:
            X += 1
        continue
    else:
        q.append((Y, X))
        maps[Y][X] = 0
        count = 1
        while q:
            group = True
            y, x = q.popleft()
            
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
    
                if 0<=nx<N and 0<=ny<N and maps[ny][nx] == 1:
                    q.append((ny, nx))
                    maps[ny][nx] = 0
                    count += 1
        ans.append(count)

ans.sort()
print(len(ans))
for i in ans:
    print(i)