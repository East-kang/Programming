"""
[트리, DFS]
1. 트리 구조 생성 (부모 → 자식)
2. 삭제할 노드 D를 입력받음
3. 루트가 삭제 노드면 트리 전체가 사라지므로 0 출력
4. DFS 수행 시, 삭제 노드를 자식에서 제외하고 탐색
5. 삭제 이후 자식이 없는 노드를 리프 노드로 간주하여 count 증가
"""

import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
graph = [[] for _ in range(N)]
for i in range(N):
    n = arr[i]   # n: 부모 노드 / i: 자식 노드
    if n == -1:
        root = i
        continue
    graph[n].append(i)

D = int(input())

stack = [root]
count = 0
if root == D:
    print(0)
    exit(0)

while stack:
    v = stack.pop()
        
    isChild = False
        
    for u in graph[v]:
        if u == D:
            continue
        isChild = True
        stack.append(u)
    if not isChild:
        count += 1
print(count)