"""
[BFS 활용 문제]
1. 주어진 순서에 따라 graph 정렬하기
2. 정렬된 graph를 BFS 했을 때, 순서가 주어진 순서와 같은지 비교하기
"""

import sys
input = sys.stdin.readline
from collections import deque

# 그래프 생성
N = int(input())
graph = {i: [] for i in range(1, N+1)}
for _ in range(N-1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

# 테스트 순서
order = list(map(int, input().split()))

# 테스트 순서 시작 정점이 1이 아니면 바로 종료
if order[0] != 1:
    print(0)
    exit()

# 테스트 순서에 따라 정점 방문 순서 저장
pos = [0]*(N+1)
for i, x in enumerate(order):
    pos[x] = i

# 각 노드에 연결된 자식 노드의 순서를 pos에 따라 오름차순 정렬
for u in range(1, N+1):
    graph[u].sort(key=lambda x: pos[x])

visited = [False]*(N+1)
q = deque()
q.append(1)
visited[1] = True
answer = [1]
while q:
    u = q.popleft()
    for v in graph[u]:
        if not visited[v]:
            visited[v] = True
            q.append(v)
            answer.append(v)

# 테스트 순서와 테스트 순서에 따른 graph의 bfs 결과 비교
if order == answer:
    print(1)
else:
    print(0)