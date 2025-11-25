"""
[투 포인터]
1. 오름차순 정렬
2. start=0, end=n으로 시작
3. 두 수의 합이 작다면 start++, 크다면 end--
"""

import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
x = int(input())

nums.sort()
start, end = 0, n-1
count = 0
while start < end:
    s = nums[start] + nums[end]
    if s == x:
        count += 1
        start += 1
    elif s < x:
        start += 1
    else:
        end -= 1
print(count)