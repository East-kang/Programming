import sys
input = sys.stdin.readline
n, m = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(n)]
chk = [[False]*m for _ in range(n)]
cnt = 0
maxv = 0

dy = [0,1,0,-1]
dx = [1,0,-1,0]
def bfs(y, x):
    q = [(y, x)]
    rs = 1
    
    while q:
        ey, ex = q.pop()
        
        for k in range(4):
            ny = ey + dy[k]
            nx = ex + dx[k]
            
            if 0<=ny<n and 0<=nx<m:
                if box[ny][nx] == 1 and chk[ny][nx] == False:
                    chk[ny][nx] = True
                    rs += 1
                    q.append((ny, nx))
    return rs

for j in range(n):
    for i in range(m):
        if box[j][i] == 1 and chk[j][i] == False:
            chk[j][i] = True
            cnt += 1
            maxv = max(maxv, bfs(j, i))
            
print(cnt)
print(maxv)