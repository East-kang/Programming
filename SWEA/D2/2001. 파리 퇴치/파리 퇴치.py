"""
[부분합, 슬라이싱]
1. 부분합: 가로로 부분합 생성
2. 우측 M번째 부분합들을 세로 방향으로 M개만큼 더해서 값 저장
3. 슬라이싱: (N, N)까지 슬라이싱
"""

T = int(input())
for t in range(1, T+1):
    N, M = map(int, input().split())
    maps = [[0]*(N+1) for _ in range(N+1)]
    for j in range(1, N+1):
        nums = list(map(int, input().split()))
        for i in range(1, N+1):
            maps[j][i] = maps[j][i-1] + nums[i-1]

    ans = 0
    for j in range(1, N-M+2):
        for i in range(M, N+1):
            pre = sum(maps[k][i-M] for k in range(j, j+M))
            s = sum(maps[k][i] for k in range(j, j+M))
            if ans < s-pre:
                ans = s-pre
    print(f"#{t} {ans}")