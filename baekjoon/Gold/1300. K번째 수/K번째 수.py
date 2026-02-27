"""
[이진 탐색]
1. B의 크기:NxN -> 최초 중앙값 인덱스(mid = (N*N)//2)
2. B[mid]의 크기 이하인 경우의 수
   1) 특정 i열에서 해당하는 갯수: m = min(B[mid]//i, N)
   2) 1~N열까지 전부 합산
   3) m>k: end = mid-1 / else: start = mid+1
3. B[start]가 정답

즉, 특정 수보다 작은 수의 갯수를 이분법으로 계산해 추리하기
"""

import sys
input = sys.stdin.readline

N = int(input())
k = int(input())

start = 1
end = k  # k번째 수는 k보다 클 수 없기에 1~k 사이에서 k번째 수를 찾으면 됌
while start<=end:
    mid = (start+end)//2

    count = 0
    for i in range(1, N+1):    # 1~N열 중 mid보다 작은 값들의 수
        count += min(N, mid//i)
    
    if count >= k:
        ans = mid
        end = mid-1
    else:
        start = mid+1

print(ans)