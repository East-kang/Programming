"""
[BFS]
1. 큐, 방문 여부 배열 생성
2. 가로/세로 증감 선언
3. bfs 시작, 시작점 큐에 추가
4. 큐 pop, 전방향에서 map 범위 내 maps 값 1 탐색
5. 방문 여부 확인
6. 조건 참인 부분 큐에 추가
7. map 부분에 이동 거리 갱신
8. map[row-1][col-1] 값 반환
9. 값이 1이면 -1 반환
"""

from collections import deque

def solution(maps):
    answer = 0
    n = len(maps)
    m = len(maps[0])
    q = deque()
    visited = [[False]*m for _ in range(n)]
    visited[0][0] = True
    q.append((0, 0))

    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    while q:
        y, x = q.popleft()

        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]

            if 0<=nx<m and 0<=ny<n and maps[ny][nx] == 1:
                if not visited[ny][nx]:
                    visited[ny][nx] = True
                    q.append((ny, nx))
                    maps[ny][nx] = maps[y][x]+1
    if maps[n-1][m-1] == 1:
        return -1
    else:
        return maps[n-1][m-1]