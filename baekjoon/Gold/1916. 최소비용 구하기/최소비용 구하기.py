"""
[다익스트라 알고리즘 활용 예제]
1. 거리를 전부 INF(1e8)로 초기화
2. 시작 정점과 연결된 정점으로 가는 최소 거리를 갱신
3. 도착 정점 도달 시 종료
"""
import heapq, sys

def dijkstra(graph, start, end):
    INF = 1e8
    distance = [INF]*(N+1)
    q = [(0, start)]
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue

        for i in graph[now]:
            if dist+i[1] < distance[i[0]]:
                distance[i[0]] = dist+i[1]
                heapq.heappush(q, (distance[i[0]], i[0]))
            
    return distance[end]


input = sys.stdin.readline
N = int(input())
M = int(input())

graph = [[] for _ in range(N+1)]
for _ in range(M):
    s, e, d = map(int, input().split())
    graph[s].append((e, d))
start, end = map(int, input().split())

print(dijkstra(graph, start, end))