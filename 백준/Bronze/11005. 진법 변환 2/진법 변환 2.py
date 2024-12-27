def solution(n, q):
    s=''

    while n > 0:
        n, mod = divmod(n, q)
        if mod>=10:
            mod = chr(ord('A')+mod-10)
        s+=str(mod)

    return s[::-1]

N,B = map(int, input().split())
print(solution(N, B))