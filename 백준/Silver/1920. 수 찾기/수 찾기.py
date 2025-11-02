"""
[이진 탐색]
1. 오름차순 정렬
2. 중앙값과 크기 비교
3. 찾을 값이 이전 index 값보다 크면 start = mid+1, 작으면 end = mid-1
4. start <= end일 때까지 반복
"""

import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
A.sort()

M = int(input())
B = list(map(int, input().split()))

for num in B:
    start = 0
    end = N-1
    while start<=end:
        mid = (start+end)//2
        if A[mid] == num:
            result = 1
            break
        if A[mid] > num:
            result = 0
            end = mid-1
        else:
            result = 0
            start = mid+1
    print(result)