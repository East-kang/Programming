import sys
from collections import deque
input = sys.stdin.readline

n, m, r = map(int, input().split())

# 그래프 (1-based)
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 인접 리스트 오름차순 정렬
for u in range(1, n + 1):
    graph[u].sort()

# 방문 순서 기록 배열 (0이면 미방문)
order = [0] * (n + 1)

def bfs(start):
    cnt = 1
    dq = deque([start])
    order[start] = cnt  # 시작 정점 방문 순서 1
    cnt += 1

    while dq:
        u = dq.popleft()
        # E(u): u의 인접 정점 목록 → graph[u]
        for v in graph[u]:
            if order[v] == 0:           # 아직 방문 안 했으면
                order[v] = cnt          # 방문 순서 기록
                cnt += 1
                dq.append(v)

bfs(r)

# 1..n 각 정점의 방문 순서 출력
for i in range(1, n + 1):
    print(order[i])
