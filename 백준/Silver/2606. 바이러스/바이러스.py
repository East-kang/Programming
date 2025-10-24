"""
<BFS>
1. 시작 정점부터 연결되어 있는 정점 갯수 세기
2. 조건 충족 시 1로 갱신 (초기 0)
3. 최종 result 배열 총합 구하기
"""

import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
B = int(input())

maps = [[0]*(N+1) for _ in range(N+1)]
for i in range(B):
    a, b = map(int, input().split())
    maps[a][b] = maps[b][a] = 1

visited = [0]*(N+1)
q = deque()
count = 0
q.append(1)
visited[1] = 1
while q:
    v = q.popleft()
    for i in range(N+1):
        if maps[v][i] == 1 and visited[i] == 0:
            q.append(i)
            visited[i] = 1
            count += 1
print(count)