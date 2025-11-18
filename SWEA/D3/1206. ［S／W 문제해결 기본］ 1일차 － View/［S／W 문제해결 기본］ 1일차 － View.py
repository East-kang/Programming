for num in range(10):
    N = int(input())
    apt = list(map(int, input().split()))
    count = 0
    for i in range(2, N-2):
        x = min(apt[i]-apt[i-2], apt[i]-apt[i-1], apt[i]-apt[i+1], apt[i]-apt[i+2])
        if x<0:
            continue
        count += x
    print(f"#{num+1} {count}")