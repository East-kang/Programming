T = int(input())
for t in range(T):
    N = int(input())
    print(f"#{t+1}")

    arr = [[0]*N for _ in range(N)]
    dx = [1, 0, -1, 0] # 우하좌상
    dy = [0, -1, 0, 1]
    y = x = 0
    def snail(y, x, d, num):
        arr[y][x] = num
        ny = y + dy[d]
        nx = x + dx[d]
        if num >= N*N:
            return
        if ny<0 or nx<0 or nx>=N or ny>=N or arr[ny][nx] != 0:
            d = (d+1) % 4
            snail(y, x, d, num)
        else:
            snail(ny, nx, d, num+1)

    snail(0, 0, 0, 1)

    for j in range(N):
        for i in range(N):
            print(arr[j][i], end =' ')
        print()