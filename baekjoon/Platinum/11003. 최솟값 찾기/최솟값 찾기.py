"""
[슬라이드 윈도우 활용]
1. 큐 활용
2. (순서, 값)으로 큐에 저장
3. 큐에 값이 추가되면 최솟값 갱신
   1) 추가한 수열의 값을 앞 값과 비교해서 앞 값이 더 클때까지 앞 값 pop(0)
   2) 수열의 수가 L을 초과하면 pop(0)
"""

import sys
input = sys.stdin.readline
write = sys.stdout.write
from collections import deque
N, L = map(int, input().split())
nums = list(map(int, input().split()))

q = deque([])
for i in range(N):
    if q and i-q[0][0] >= L:
        q.popleft()
        
    while q and q[-1][1] > nums[i]:
        q.pop()
        
    q.append((i, nums[i]))
    print(q[0][1], end=' ')