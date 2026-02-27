"""
[이진 탐색]
1. 블루레이 크기 범위 구하시
2. 해당 범위에서 이진 탐색해 최소 크기 찾기
3. 중간 크기를 가지고, 강의 길이 합이 포함되고 블루레이가 M개가 되는지 확인
"""

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))

# 동영상 길이 범위
start = 0
end = 0
for i in nums:
    start = max(start, i)
    end += i

maximum = 0
minimum = 1e8
while start<=end:
    mid = (start+end)//2
    count = 1
    num_sum = 0
    for i in nums:
        if num_sum+i <= mid:
            num_sum += i
        else:
            count += 1
            maximum = max(maximum, num_sum)
            num_sum = i
    
    maximum = max(maximum, num_sum)
    if count > M:
        start = mid + 1
    else:
        end = mid - 1
print(start)