"""
[소수 구하기]
1. 소수 판별 함수 정의
2. 2부터 최대값의 제곱근까지 반복
3. 소수에 대해 2~제곱근 유효성 확인
"""

import sys
input = sys.stdin.readline
A, B = map(int, input().split())

# 에라토스테네스 체 알고리즘
prime = [True]*(int(B**0.5)+1)
prime[1] = False
for i in range(2, int(B**0.5)+1):
    if not prime[i]:
        continue
    for j in range(i*2, int(B**0.5)+1, i):
        prime[j] = False

# 제곱근 판별
count = 0
for n in range(2, int(B**0.5)+1):
    if prime[n]:
        e = 2
        while n**e<=B:
            if n**e>=A:
                count += 1
            e += 1

print(count)