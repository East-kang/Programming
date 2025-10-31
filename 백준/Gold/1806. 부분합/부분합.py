"""
시간 제한: 1초 -> O(nlogn) 안으로 풀어야함.
1. 투 포인터 활용
2. end를 늘리면서 S보다 커지는 지점 찾기
3. 해당 지점에 필요한 수의 갯수(count) 저장
4. start를 1 증가시키고 count를 1 낮춰 S보다 큰 부분 찾기
5. end가 마지막 항목을 넘기거나, count가 1이 되면 중지
"""

import sys
input = sys.stdin.readline

N, S = map(int, input().split())
nums = list(map(int, input().split()))

s, e = 0, 0
count = N+1
T = nums[s]
while count > 1:
    if T >= S:
        count = e-s+1
        T -= (nums[s]+nums[e])
        s += 1
    else:
        if count == N+1:
            e += 1
        else:
            T -= nums[s]
            s += 1
            e += 1
    if e == N:
        break
    T += nums[e]

print(count % (N+1))