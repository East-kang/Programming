"""
[소수 판별 함수 활용]
1. 특정 값의 제곱근 + 1까지 나눴을 때 나눠지지 않으면 소수로 판별
2. 한 자리부터 소수를 판별하고 저장 (데큐 활용)
3. 저장한 소수에 10을 곱한 상태에서 일의 자리를 추가하면서 소수 판별하고 저장
4. 마지막에는 소수 판별 시 바로 출력
"""

import sys, math
from collections import deque
input = sys.stdin.readline

# 소수면 True, 아니면 False
def is_prime(n):
    if n < 2:
        return False
    if n == 2:
        return True
    for i in range(2, int(math.sqrt(n))+2):
        if n%i == 0:
            return False
    return True

N = int(input())
tmp = deque()
tmp.append(0)
for k in range(N):
    n = len(tmp)
    for j in range(n):
        for i in range(tmp[0]*10, (tmp[0]+1)*10):
            if is_prime(i):
                if k < N-1:
                    tmp.append(i)
                else:
                    print(i)
        tmp.popleft()