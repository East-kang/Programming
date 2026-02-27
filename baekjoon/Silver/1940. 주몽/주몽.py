"""
[투 포인터 활용]
1. 재료 목록(nums) 오름차순 정렬
2. start(0), end(N-1) 인덱스부터 시작
3. 두 인덱스에 해당하는 값의 합(S)과 M 비교
    1) S == M : count+1, start+1, end-1
    2) S < M : start+1
    3) S > M : end+1
"""

import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
nums = list(map(int, input().split()))
nums.sort()

start = 0
end = N-1
count = 0
while start < end:
    S = nums[start] + nums[end]
    if S == M:
        count += 1
        start += 1
        end -= 1
    elif S < M:
        start += 1
    else:
        end -= 1

print(count)