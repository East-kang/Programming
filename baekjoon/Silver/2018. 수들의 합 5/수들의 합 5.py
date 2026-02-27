"""
[이중 for문 활용]
1. count = 1부터 시작 (N 자체의 경우)
2. start, end 포인트 index: 0부터 시작
3. start부터 end까지 수를 더하면서 N보다 커지기 전까지 end 증가
4. N보다 크면 start 증가, end 정지
5. 다시 N보다 작으면 start 정지, end 증가
6. end == N일 경우 중
"""

import sys
input = sys.stdin.readline

N = int(input())

count, start, end, S = 1, 1, 1, 1

while end < N:    
    if S < N:
        end += 1
        S += end
    elif S > N:
        S -= start
        start += 1
    else:
        count += 1
        S -= start
        start += 1
        
print(count)