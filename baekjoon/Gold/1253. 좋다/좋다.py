"""
[투 포인트 활용 예제]
1. 수 오름차순으로 정렬
2. 양 끝 숫자의 합으로 좁혀나가면서 수행
3. 음수가 포함될 수 있으니 전체 값에 대한 투 포인터 활용
"""

import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
nums.sort()
count = 0

for i in range(N):
    s = 0
    e = N-1
    while s < e:
        S = nums[s]+nums[e]
        if S == nums[i]:
            if i == s:
                s += 1
            elif i == e:
                e -= 1
            else:
                count += 1
                break
        elif S < nums[i]:
            s += 1
        else:
            e -= 1
        
print(count)