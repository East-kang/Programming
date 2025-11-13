T = int(input())
for j in range(T):
    N = int(input())
    prices = list(map(int, input().split()))
    sell = ans = 0
    for p in prices[::-1]:
        if sell < p:
            sell = p
        else:
            ans += (sell-p)
    print(f"#{j+1} {ans}")