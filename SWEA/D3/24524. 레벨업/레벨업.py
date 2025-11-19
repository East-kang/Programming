"""
[부분합 문제]
1. i: 0~N까지 인접한 값들의 부분합 정리
2. 정리하면서 총합 구하기
3. i: 1~N-1까지 임의의 포인트 k를 제외한 경우들 저장
    1) k-1, k번째 부분합 제거 후 k-1~k+1까지 구간값 더하기
    2) 따로 배열에 저장한 후 최솟값 구하기
"""

T = int(input())
for _ in range(T):
    N = int(input())
    points = list(map(int, input().split()))
    s = [0]*(N-1)
    minimum = 1e8
    total = 0
    for i in range(N-1):
        s[i] = abs(points[i+1]-points[i])
        total += s[i]
    for i in range(1, N-1):
        minimum = min(minimum, total-s[i-1]-s[i]+abs(points[i+1]-points[i-1]))
    print(minimum)