"""
[트리 순회]
1. Inorder  : 왼 -> 루트 -> 오
   Postorder: 왼 -> 오 -> 루트   =>  Postorder의 마지막 노드는 루트 노드

2. Inorder에서 루트의 위치를 찾으면
   - 루트 기준 왼쪽은 왼 서브트리
   - 루트 기준 오른쪽은 오른 서브트리

3. 왼/오른 서브트리의 노드 개수를 계산하여
   Postorder에서도 같은 크기로 왼/오른 부분을 나눌 수 있음

4. 전위 순회 구조(루트 -> 왼 -> 오른쪽)에 맞춰
   - 루트를 출력하고
   - 왼쪽 구간 재귀
   - 오른쪽 구간 재귀

※ 리스트 슬라이싱 대신 인덱스 범위로 처리 (대량 데이터 대비)
"""

import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())
inOrder = list(map(int, input().split()))
postOrder = list(map(int, input().split()))
inPos = [0]*(n+1)
for j, i in enumerate(inOrder):
    inPos[i] = j

ans = []
def build_preOrder(il, ir, pl, pr):
    if il>ir or pl>pr:
        return
    root = postOrder[pr]
    ans.append(str(root))
    
    rootIdx = inPos[root]
    leftSize = rootIdx-il
    

    build_preOrder(il, rootIdx-1, pl, pl+leftSize-1)
    build_preOrder(rootIdx+1, ir, pl+leftSize, pr-1)

build_preOrder(0, n-1, 0, n-1)
print(' '.join(ans))